package com.gbg.reporting.cucumber.models;

import lombok.Data;

import java.util.List;

@Data
public class CucumberElement {
    private int line;
    private String name;
    private String description;
    private String id;
    private String type;
    private String keyword;
    private List<CucumberStep> steps;
    private List<CucumberBefore> before;
    private List<CucumberAfter> after;
    private List<CucumberTag> tags;

}
