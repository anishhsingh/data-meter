package com.datameter.processor;

import com.datameter.model.UsageRecord;
import com.datameter.model.UsageSummary;
import com.datameter.utils.ConfigLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class FileProcessor {

    // Processes all files in a directory and aggregates usage summaries
    public Map<String, UsageSummary> processDirectory(File folder) throws Exception {
        Map<String, UsageSummary> summaryMap = new HashMap<>();
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                processFile(file, summaryMap); // process each file
            }
        }
        return summaryMap;
    }

    // Processes a single file line by line and updates the summary map
    private void processFile(File file, Map<String, UsageSummary> summaryMap) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int lineNum = 0;
        while ((line = reader.readLine()) != null) {
            lineNum++;
            try {
                UsageRecord record = RecordParser.parseLine(line); // Parse each line
                summaryMap.putIfAbsent(record.getMobileNumber(), new UsageSummary(record.getMobileNumber()));
                summaryMap.get(record.getMobileNumber()).addUsage(record); // Add usage to summary
            } catch (Exception e) {
                System.err.println("Skipping line " + lineNum + " in file " + file.getName() + ": " + e.getMessage());
            }
        }
        reader.close();
    }

    // Prints the summarized results in table format
    public void printResults(Map<String, UsageSummary> summaryMap) {
        System.out.println("Mobile Number|4G|5G|4G Roaming|5G Roaming|Cost");
        for (UsageSummary summary : summaryMap.values()) {
            System.out.println(summary);
        }
    }

}
