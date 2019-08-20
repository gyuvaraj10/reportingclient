package com.tests;

import com.gbg.reporting.cucumber.models.*;
import com.gbg.reporting.cucumber.utils.CucumberReport;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class ReportFeedTest {

    @Test
    public void testPaserJsonReport() throws Exception {
        String url = "http://localhost:8983/solr/gettingstarted/update?commit=true";
        String serviceName = "Match";
        String content = FileUtils.readFileToString(new File(this.getClass().getResource("/cucumber.json").getPath()), Charset.defaultCharset());
        List<CucumberResultReport> resultReports = CucumberReport.getCucumberReport(content);
        String timeStamp = Instant.now().toString();
        String buildNumber = "0.4";
        List<Report> reports = new ArrayList<>();
        for(CucumberResultReport resultReport: resultReports){
            for(CucumberElement element: resultReport.getElements()) {
                Report report = new Report();
                report.setBuildNumber(buildNumber);
                report.setScenarioName(element.getName()+element.getDescription());
                report.setFeatureName(resultReport.getName());
                List<Result> results = element.getBefore().stream().filter(x->x.getResult() != null).map(CucumberBefore::getResult).collect(Collectors.toList());
                if(element.getBefore() != null) {
                    results.addAll(element.getSteps().stream().filter(x -> x.getResult() != null).map(CucumberStep::getResult).collect(Collectors.toList()));
                }
                if(element.getAfter() != null) {
                    results.addAll(element.getAfter().stream().filter(x -> x.getResult() != null).map(x -> x.getResult()).collect(Collectors.toList()));
                }
                Optional<Result> failResultOptional = results.stream().filter(x->x.getStatus().contains("fail")).findFirst();
                if(failResultOptional.isPresent()) {
                    report.setFailed(true);
                    report.setShortErrorMessage(failResultOptional.get().getError_message().substring(0, 100));
                    report.setFailureMessage(failResultOptional.get().getError_message());
                    report.setStatus("failed");
                } else {
                    Optional<Result> skipResultOptional = results.stream().filter(x->x.getStatus().contains("skip")).findFirst();
                    if(skipResultOptional.isPresent()) {
                        report.setSkipped(true);
                        report.setStatus("skipped");
                    } else {
                        report.setPassed(true);
                        report.setStatus("passed");
                    }
                }
                List<CucumberTag> tags = element.getTags();
                report.setTags(tags.stream().map(x->x.getName()).collect(Collectors.toList()));
                report.setServicename(serviceName);
                report.setScenario(captureScenario(element));
                report.setTimeStamp(timeStamp);
                reports.add(report);
            }
        }
        reports.addAll(reports.subList(0,110));
        Gson gson = new Gson();
        String json = gson.toJson(reports);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        HttpResponse<JsonNode> entity = Unirest.post(url).headers(headers).body(json).asJson();
        int statusCode = entity.getStatus();
        System.out.println(statusCode);
        System.out.println(entity.getBody().toString());

    }

    private String captureScenario(CucumberElement element) {
        StringBuilder scenarioSteps = new StringBuilder();
        scenarioSteps.append(String.format("Scenario: %s",element.getName()));
        scenarioSteps.append("\n");
        for(CucumberStep step: element.getSteps()) {
            scenarioSteps.append(step.getKeyword()+" "+step.getName());
            scenarioSteps.append("\n");
        }
        return scenarioSteps.toString();
    }

    @Test
    @Ignore
    public void deleteData() throws Exception {
        String url = "http://localhost:8983/solr/gettingstarted/update?stream.body=<delete><query>*:*</query></delete>&commit=true";
        HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        System.out.println(response.getStatus());
        System.out.println(response.getBody().toString());
    }

    @Test
    public void test() {
        System.out.println(Instant.now().toString());
    }
}