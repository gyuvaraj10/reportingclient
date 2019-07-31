package com.gbg.reporting.cucumber.models;

import lombok.Data;

@Data
public class CucumberStep {

    private int line;
    private String name;
    private String keyword;
    private Result result;
    private Match match;
}
