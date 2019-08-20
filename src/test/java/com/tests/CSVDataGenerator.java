package com.tests;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.UUID;

public class CSVDataGenerator {

    @Test
    public void test123() throws IOException {
        File file = new File("C:\\Users\\yuvaraj.gunisetti\\dev\\reportingclient\\src\\test\\resources\\testdata.csv");
        for(int i=0; i<5000; i++) {
            String personId = UUID.randomUUID().toString();
            String verificationId = UUID.randomUUID().toString();
            String record  = String.format("%s,%s\n", personId, verificationId);
            FileUtils.write(file, record, Charset.defaultCharset(), true);
        }
    }
}
