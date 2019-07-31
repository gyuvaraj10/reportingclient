package com.gbg.reporting.cucumber.models;

import lombok.Data;

@Data
public class Result {
    private String duration;
    private String status;
    private String error_message;
}
