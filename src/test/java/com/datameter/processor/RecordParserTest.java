package com.datameter.processor;

import com.datameter.model.UsageRecord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecordParserTest {

    @Test
    public void testParseValidLine() throws Exception {
        String line = "9000600601|Tower1|1345|0|Yes";
        UsageRecord record = RecordParser.parseLine(line);

        assertEquals("9000600601", record.getMobileNumber());
        assertEquals(1345, record.getData4G());
        assertEquals(0, record.getData5G());
        assertTrue(record.isRoaming());
    }

    @Test
    public void testParseInvalidLine() {
        String line = "Invalid|Line|With|Missing|Fields";
        assertThrows(Exception.class, () -> RecordParser.parseLine(line));
    }
}
