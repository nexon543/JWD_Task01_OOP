package by.tc.task01.util.source_reader;

import java.util.ResourceBundle;

public class SourceNameReader {

    private ResourceBundle properties;

    public SourceNameReader() {
    }

    public String readApplianceFilePath() {
        properties = ResourceBundle.getBundle(DBParameter.CONFIG_FILE_PATH);
        String applianceFilePath = properties.getString(DBParameter.APPLIANCE_FILE_PATH_KEY);
        return applianceFilePath;
    }

}