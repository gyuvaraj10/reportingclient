package com.gbg.reporting.cucumber.utils;

import com.gbg.reporting.cucumber.models.CucumberResultReport;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class CucumberReport {
    private CucumberReport() {}
    private static final Gson GSON = new Gson();

    public static List<CucumberResultReport> getCucumberReport(String jsonReport) {
        Type listType = new TypeToken<List<CucumberResultReport>>() {}.getType();
        return GSON.fromJson(jsonReport, listType);
    }
}
