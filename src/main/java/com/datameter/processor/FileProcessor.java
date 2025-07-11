package com.datameter.processor;

import com.datameter.model.UsageRecord;
import com.datameter.model.UsageSummary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileProcessor {
    private static final Logger logger = Logger.getLogger(FileProcessor.class.getName());

    public Map<String, UsageSummary> processDirectory(File folder) throws Exception {
        Map<String, UsageSummary> summaryMap = new HashMap<>();
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                logger.info("Processing file: " + file.getName());
                processFile(file, summaryMap);
            }
        }
        return summaryMap;
    }

    private void processFile(File file, Map<String, UsageSummary> summaryMap) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int lineNum = 0;
        while ((line = reader.readLine()) != null) {
            lineNum++;
            try {
                UsageRecord record = RecordParser.parseLine(line);
                summaryMap.putIfAbsent(record.getMobileNumber(), new UsageSummary(record.getMobileNumber()));
                summaryMap.get(record.getMobileNumber()).addUsage(record);
            } catch (Exception e) {
                logger.log(Level.WARNING, "Skipping line " + lineNum + " in file " + file.getName() + ": " + e.getMessage());
            }
        }
        reader.close();
    }

    public void printResults(Map<String, UsageSummary> summaryMap) {
        System.out.println("Mobile Number|4G|5G|4G Roaming|5G Roaming|Cost");
        for (UsageSummary summary : summaryMap.values()) {
            System.out.println(summary);
        }
    }
}
