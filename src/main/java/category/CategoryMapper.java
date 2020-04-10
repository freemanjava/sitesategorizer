package category;

import fetch.TextFetcher;
import lombok.extern.slf4j.Slf4j;
import models.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
public class CategoryMapper {

    private final long TIME_TERMINATION = 10;
    private final int THREAD_COUNTER = 20;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNTER);
    private final List<String> urls;
    private final List<Category> categories;
    private final TextFetcher textFetcher = new TextFetcher();


    public CategoryMapper(List<String> urls, List<Category> categories) {
        this.urls = urls;
        this.categories = categories;
    }

    public Map<String, List<String>> getCategoryMapping(){
        Map<String, List<String>> mappedUrls = serviceExecute();
        serviceShutdown();
        return mappedUrls;
    }

    private Map<String, String> fetchText (){
        return textFetcher.getTextBulkUrls(urls);
    }

    private Map<String, List<String>> serviceExecute() {
        Map<String, List<String>> mappedUrls  = new HashMap<>();
        Map<String, List<String>> result = new HashMap<>();
        Map<String, String> fetchedText = fetchText();

        List<CategoryFinder> taskList = new ArrayList<>();
        for (String url : fetchedText.keySet()){
            String text = fetchedText.get(url);
            taskList.add(new CategoryFinder(url, text, categories));
        }

        List<Future<Map<String, List<String>>>> futures = null;
        try {
            futures = executorService.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (futures == null) {
//            log.warn("Parser didn't work");
        } else {
            for (Future<Map<String, List<String>>> future : futures) {
                if (future == null) {
//                    log.warn("Something wrong with url: ");
                } else {
                    try {
                        mappedUrls = future.get();
                    } catch (InterruptedException e) {
//                        log.warn("InterruptedException: " + mappedUrls.keySet());
                    } catch (ExecutionException e) {
//                        log.warn("ExecutionException: " + mappedUrls.keySet());
                    }
                    result.putAll(mappedUrls);
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
