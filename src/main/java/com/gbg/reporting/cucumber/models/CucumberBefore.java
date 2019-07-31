package com.gbg.reporting.cucumber.models;

import lombok.Data;

@Data
public class CucumberBefore {
    private Result result;
    private Match match;
}
