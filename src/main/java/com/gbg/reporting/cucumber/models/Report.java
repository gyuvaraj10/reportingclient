package com.gbg.reporting.cucumber.models;

import lombok.Data;

import java.util.List;

@Data
public class Report {
    private String servicename;
    private String featureName;
    private String scenarioName;
    private String failureMessage;
    private boolean failed;
    private boolean skipped;
    private boolean passed;
    private String status;
    private List<String> tags;
}