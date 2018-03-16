package by.tc.task01.util.parser;

import java.util.Map;

public interface ApplianceRecordParser {
    Map<String, String> parse(String applianceRecord);
}
