package fetch;

import lombok.extern.slf4j.Slf4j;
import utils.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
public class TextFetcher {

    private final long TIME_TERMINATION = 10;
    private final int THREAD_COUNTER = 20;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNTER);

    public Map<String, String> getTextBulkUrls(List<String> urls){
        Map<String, String> result = serviceExecute(urls);
        serviceShutdown();
        return result;
    }

    public String getTextSingleUrl(String url) throws IOException {
        Parser parser = new Parser(url);
        return parser.getTextFromUrl(url);
    }

    private Map<String, String> serviceExecute(List<String> urls) {
        Map<String, String> parsedTextFromUrl = new HashMap<>();
        Map<String, String> result = new HashMap<>();
        List<Parser> taskList = new ArrayList<>();

        for (String url : urls) {
            taskList.add(new Parser(url));
        }

        List<Future<Map<String, String>>> futures = null;
        try {
            futures = executorService.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (futures == null) {
//            log.warn("Parser didn't work");
        } else {
            for (Future<Map<String, String>> future : futures) {
                if (future == null) {
//                    log.warn("Something wrong with url: ");
                } else {
                    try {
                        parsedTextFromUrl = future.get();
                    } catch (InterruptedException e) {
//                        log.warn("InterruptedException: " + parsedTextFromUrl.keySet());
                    } catch (ExecutionException e) {
//                        log.warn("ExecutionException: " + parsedTextFromUrl.keySet());
                    }
                    result.putAll(parsedTextFromUrl);
                }
            }
        }
        return result;
    }

    private void serviceShutdown(){
        try {
            executorService.shutdown();
            executorService.awaitTermination(TIME_TERMINATION, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
//            log.warn("tasks interrupted");
        }
        finally {
            if (!executorService.isTerminated()) {
//                log.warn("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println();
//            log.info("Shutdown finished");
        }
    }
}
