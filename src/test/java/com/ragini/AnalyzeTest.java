package com.ragini;


import com.ragini.model.AnalysisResponse;
import com.ragini.service.AnalyzeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AnalyzeTest {

    @Autowired
    AnalyzeService analyzeService;


    @Test                                        // Test Case 1: Valid URL
    void testValidUrl() throws IOException {
        System.out.println("Running testValidUrl...");
        AnalysisResponse response = analyzeService.
                analyzeWebsite("https://spring.io");
        assertNotNull (response);
        assertEquals(200,response.getStatus());
        assertNotNull(response.getTitle());
        assertTrue(response.getWordCount() > 0);
        assertTrue(response.getResponseTime() >= 0);

    }
    // Test Case 2: Another Valid URL
    @Test
    void testGoogleWebsite() throws IOException {

        AnalysisResponse response =
                analyzeService.analyzeWebsite("https://google.com");

        assertNotNull(response);
        assertEquals(200, response.getStatus());
        assertNotNull(response.getTitle());
        assertTrue(response.getResponseTime() >= 0);

    }
    // Test Case 3: Empty URL
    @Test
    void testEmptyUrl() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> analyzeService.analyzeWebsite("")
        );

        assertEquals("URL cannot be empty.", exception.getMessage());
    }

    // Test Case 4: Null URL
    @Test
    void testNullUrl() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> analyzeService.analyzeWebsite(null)
        );

        assertEquals("URL cannot be empty.", exception.getMessage());
    }

    // Test Case 5: URL without http:// or https://
    @Test
    void testUrlWithoutHttp() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> analyzeService.analyzeWebsite("google.com")
        );

        assertEquals(
                "URL must start with http:// or https://",
                exception.getMessage()
        );
    }

    // Test Case 6: Invalid Website
    @Test
    void testInvalidWebsite() {

        assertThrows(IOException.class, () ->
                analyzeService.analyzeWebsite(
                        "https://thiswebsitedoesnotexist12345.com"
                )
        );
    }
}
