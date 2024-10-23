import java.io.IOException;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.Reader;
import java.util.List;
import java.io.InputStreamReader;
import com.google.gson.Gson; 

import org.jsoup.Jsoup;
import java.net.URLDecoder;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearchJava {

	public static void main(String[] args) throws Exception {
String google = "http://www.google.com/search?q=";
String search = "stackoverflow";
String charset = "UTF-8";
String userAgent = "ExampleBot 1.0 (+http://example.com/bot)"; // Change this to your company's name and bot homepage!

Elements links = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select(".g>.r>a");

for (Element link : links) {
    String title = link.text();
    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
    url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");
    
    if (!url.startsWith("http")) {
        continue; // Ads/news/etc.
    }
    
    System.out.println("Title: " + title);
    System.out.println("URL: " + url);
}
}
public class GoogleResults {

    private ResponseData responseData;
    public ResponseData getResponseData() { return responseData; }
    public void setResponseData(ResponseData responseData) { this.responseData = responseData; }
    public String toString() { return "ResponseData[" + responseData + "]"; }

    static class ResponseData {
        private List<Result> results;
        public List<Result> getResults() { return results; }
        public void setResults(List<Result> results) { this.results = results; }
        public String toString() { return "Results[" + results + "]"; }
    }

    static class Result {
        private String url;
        private String title;
        public String getUrl() { return url; }
        public String getTitle() { return title; }
        public void setUrl(String url) { this.url = url; }
        public void setTitle(String title) { this.title = title; }
        public String toString() { return "Result[url:" + url +",title:" + title + "]"; }
    }

}
}