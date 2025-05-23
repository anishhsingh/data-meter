package com.datameter.processor;

import com.datameter.model.UsageRecord;

public class RecordParser {
    // Parses a line like "9876543210|Jio|1024|2048|Yes" into a UsageRecord
    public static UsageRecord parseLine(String line) throws Exception {
        String[] parts = line.split("\\|");
        if (parts.length != 5)
            throw new Exception("Invalid format");

        String mobileNumber = parts[0];
        int data4G = Integer.parseInt(parts[2]);
        int data5G = Integer.parseInt(parts[3]);
        boolean isRoaming = parts[4].equalsIgnoreCase("Yes");

        return new UsageRecord(mobileNumber, data4G, data5G, isRoaming);
    }
}
