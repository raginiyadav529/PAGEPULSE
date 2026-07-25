package com.ragini.controller;

import com.ragini.model.AnalysisResponse;
import com.ragini.model.UrlRequest;
import com.ragini.service.AnalyzeService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@RestController
public class AnalyzeController {

    @Autowired
    AnalyzeService analyzeService;

    @GetMapping("/hello")
    public String greet(){
        return "Hello ";
    }


   /* @PostMapping("/analyze")
    public AnalysisResponse analysisResponse(@RequestBody UrlRequest request){

        AnalysisResponse response =new AnalysisResponse();
        response.setStatus(200);
        response.setResponseTime(150);
        response.setTitle("Dummy Title");
        response.setMetaDescription("Dummy Description");
        response.setH1Count(2);
        response.setImagesMissingAlt(1);
        response.setWordCount(1000);

        return response;
    }
    */

//    @PostMapping("/analyze")
//    public AnalysisResponse analyze(@RequestBody UrlRequest request) throws IOException {
//        return analyzeService.analyzeWebsite(request.getUrl());
//    }


    @PostMapping("/analyze")
    public ResponseEntity<?> analyze(@RequestBody UrlRequest request) {

        try {
            AnalysisResponse response = analyzeService.analyzeWebsite(request.getUrl());
            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unable to analyze the website.");
        }
    }







}
