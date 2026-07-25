package com.ragini.model;

public class AnalysisResponse {

    private int status;
    private long responseTime;
    private String title;
    private String metaDescription;
    private int h1Count;
    private int imagesMissingAlt;
    private int wordCount;

    public AnalysisResponse() {

    }

    public AnalysisResponse(int status, long responseTime, String title,
                            String metaDescription, int h1Count,
                            int imagesMissingAlt, int wordCount) {

        this.status = status;
        this.responseTime = responseTime;
        this.title = title;
        this.metaDescription = metaDescription;
        this.h1Count = h1Count;
        this.imagesMissingAlt = imagesMissingAlt;
        this.wordCount = wordCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public int getH1Count() {
        return h1Count;
    }

    public void setH1Count(int h1Count) {
        this.h1Count = h1Count;
    }

    public int getImagesMissingAlt() {
        return imagesMissingAlt;
    }

    public void setImagesMissingAlt(int imagesMissingAlt) {
        this.imagesMissingAlt = imagesMissingAlt;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

}


