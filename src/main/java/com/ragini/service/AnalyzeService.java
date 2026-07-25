package com.ragini.service;

import com.ragini.model.AnalysisResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AnalyzeService {

    public AnalysisResponse analyzeWebsite(String url) throws IOException {

        // Validation 1: Check empty URL
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("URL cannot be empty.");
        }
        // Validation 2: Check URL format
        if (!(url.startsWith("http://") || url.startsWith("https://"))) {
            throw new IllegalArgumentException("URL must start with http:// or https://");
        }

        Document document = Jsoup.connect(url).get();
        AnalysisResponse response = new AnalysisResponse();
        response.setTitle(document.title());

        String metaDescription = document.select("meta[name=description]")
                .attr("content");
        response.setMetaDescription(metaDescription);

        int h1Count = document.select("h1").size();
        response.setH1Count(h1Count);

        Elements images= document.select("img");
        int imageMissingAlt=0;
        for(Element image:images){
            if(!image.hasAttr("alt")||image.attr("alt").isBlank()){
                imageMissingAlt++;
            }
        }
        response.setImagesMissingAlt(imageMissingAlt);

        long startTime = System.currentTimeMillis();
        Connection.Response jsoupResponse = Jsoup.connect(url).execute();
        Document document1 = jsoupResponse.parse();
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        response.setResponseTime(responseTime);

        response.setStatus(jsoupResponse.statusCode());  // Status code

        String text = document.body().text();

        int wordCount = text.trim().isEmpty()
                ? 0
                : text.trim().split("\\s+").length;

        response.setWordCount(wordCount);

        return response;
    }
}
