package com.gbg.reporting.cucumber.models;

import lombok.Data;

import java.util.List;

@Data
public class Match {
    private String location;
    private List<Arguments> arguments;
}
