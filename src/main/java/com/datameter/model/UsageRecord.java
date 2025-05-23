package com.datameter.model;

public class UsageRecord {
    private final String mobileNumber;
    private final int data4G;
    private final int data5G;
    private final boolean isRoaming;

    // Constructor to initialize all fields
    public UsageRecord(String mobileNumber, int data4G, int data5G, boolean isRoaming) {
        this.mobileNumber = mobileNumber;
        this.data4G = data4G;
        this.data5G = data5G;
        this.isRoaming = isRoaming;
    }

    // Getter methods
    public String getMobileNumber() {
        return mobileNumber;
    }

    public int getData4G() {
        return data4G;
    }

    public int getData5G() {
        return data5G;
    }

    public boolean isRoaming() {
        return isRoaming;
    }
}
