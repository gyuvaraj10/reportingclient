package com.gbg.reporting.cucumber.models;

import lombok.Data;

import java.util.List;

@Data
public class Report {
    private String id;
    private String buildNumber;
    private String servicename;
    private String featureName;
    private String scenarioName;
    private String failureMessage;
    private String shortErrorMessage;
    private boolean failed;
    private boolean skipped;
    private boolean passed;
    private String status;
    private List<String> tags;
    private String timeStamp;
    private String scenario;
    private long executionTime;
}