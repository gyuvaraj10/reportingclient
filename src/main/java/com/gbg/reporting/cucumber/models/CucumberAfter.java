package com.gbg.reporting.cucumber.models;

import lombok.Data;

@Data
public class CucumberAfter {
    private Result result;
    private Match match;
}
