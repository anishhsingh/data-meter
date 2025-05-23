package com.datameter.model;

import com.datameter.utils.ConfigLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsageSummaryTest {

    @BeforeAll
    public static void loadConfig() throws Exception {
        ConfigLoader.loadConfig(); // Make sure config.properties exists in root
    }

    @Test
    public void testComputeCostWithoutSurcharge() {
        UsageRecord record = new UsageRecord("9000600600", 1000, 500, false);
        UsageSummary summary = new UsageSummary("9000600600");
        summary.addUsage(record);

        double expected = 1000 * 0.05 + 500 * 0.10;
        assertEquals(Math.round(expected), summary.computeCost());
    }

    @Test
    public void testComputeCostWithRoaming() {
        UsageRecord record = new UsageRecord("9000600601", 2000, 1000, true);
        UsageSummary summary = new UsageSummary("9000600601");
        summary.addUsage(record);

        double expected = 2000 * 0.055 + 1000 * 0.115;
        assertEquals(Math.round(expected), summary.computeCost());
    }
}
