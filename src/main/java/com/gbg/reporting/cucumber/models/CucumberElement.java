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

//    public List<CucumberTag> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<CucumberTag> tags) {
//        this.tags = tags;
//    }
//
//    private List<CucumberTag> tags;
//
//    public int getLine() {
//        return line;
//    }
//
//    public void setLine(int line) {
//        this.line = line;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getKeyword() {
//        return keyword;
//    }
//
//    public void setKeyword(String keyword) {
//        this.keyword = keyword;
//    }
//
//    public List<CucumberStep> getSteps() {
//        return steps;
//    }
//
//    public void setSteps(List<CucumberStep> steps) {
//        this.steps = steps;
//    }
}
