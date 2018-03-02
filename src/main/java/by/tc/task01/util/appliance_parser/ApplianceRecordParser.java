package by.tc.task01.util.appliance_parser;

import java.util.Map;

public interface ApplianceRecordParser {
    public Map<String, String> parse(String applianceRecord);
}
