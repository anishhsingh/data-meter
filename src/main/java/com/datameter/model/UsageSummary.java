package com.datameter.model;

import com.datameter.utils.ConfigLoader;

public class UsageSummary {
    private final String mobileNumber;
    private int data4G;
    private int data5G;
    private int data4GRoaming;
    private int data5GRoaming;

    public UsageSummary(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // Adds a usage record (roaming and non-roaming handled separately)
    public void addUsage(UsageRecord record) {
        if (record.isRoaming()) {
            data4GRoaming += record.getData4G();
            data5GRoaming += record.getData5G();
        } else {
            data4G += record.getData4G();
            data5G += record.getData5G();
        }
    }

    // Calculates the total cost based on rates and thresholds
    public double computeCost() {
        double cost = 0.0;

        // Cost without threshold surcharge
        cost += data4G * ConfigLoader.getRate("rate.4g");
        cost += data5G * ConfigLoader.getRate("rate.5g");
        cost += data4GRoaming * ConfigLoader.getRate("rate.4g.roaming");
        cost += data5GRoaming * ConfigLoader.getRate("rate.5g.roaming");

        // Apply surcharge if usage exceeds threshold
        double totalUsage = data4G + data5G + data4GRoaming + data5GRoaming;
        if (totalUsage > ConfigLoader.getThreshold()) {
            cost *= (1 + ConfigLoader.getRate("threshold.surcharge"));
        }

        return Math.round(cost); // Rounds off the cost to nearest integer
    }

    // Formats the summary as a string to print
    @Override
    public String toString() {
        return mobileNumber + "|" + data4G + "|" + data5G + "|" + data4GRoaming + "|" + data5GRoaming + "|"
                + (int) computeCost();
    }

}
