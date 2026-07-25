package com.ragini.controller;

import com.ragini.model.AnalysisResponse;
import com.ragini.model.UrlRequest;
import com.ragini.service.AnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;


@RestController
public class AnalyzeController {

    @Autowired
    AnalyzeService analyzeService;

    @GetMapping("/hello")
    public String greet(){
        return "Hello ";
    }

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
