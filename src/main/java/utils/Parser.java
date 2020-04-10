package utils;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

@Slf4j
public class Parser implements Callable<Map<String, String>> {

    private final String webPageUrl;

    public Parser(String webPageUrl) {
        this.webPageUrl = webPageUrl;
    }

    @Override
    public Map<String, String> call() throws IOException {
        Map<String, String> resultMap = new HashMap<>();
        String text = getTextFromUrl(webPageUrl);
        resultMap.put(webPageUrl, text);
        return resultMap;
    }

    public String getTextFromUrl(String urlString) throws IOException {
        String htmlFromURL = getHTMLFromURL(urlString);
        return extractTextFromHtml(htmlFromURL);
    }

    private Elements getRawDataFromHtmlDocument(String htmlDocument){
        Document document = Jsoup.parse(htmlDocument);
        document.select("script, style, img, input, button, path").remove();
        Element body = document.body();
        return body.getAllElements();
    }

    private String extractTextFromHtml(String htmlDocument){
        Document document = Jsoup.parse(htmlDocument);
        return document.body().text();
    }

    private String getHTMLFromURL(String urlString) throws IOException {
        String htmlDocument;
        try {
            URLConnection url = new URL(urlString).openConnection();
            url.setRequestProperty("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 10_2_1 like Mac OS X) AppleWebKit/602.4.6 (KHTML, like Gecko) Version/10.0 Mobile/14D27 Safari/602.1");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();
            htmlDocument = sb.toString();
        } catch (IOException e) {
            throw e;
        }
        return  htmlDocument;
    }
}
