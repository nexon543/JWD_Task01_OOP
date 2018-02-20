package by.tc.task01.util.source_reader;

import java.io.IOException;

import by.tc.task01.util.PropertyManager;
import by.tc.task01.util.PropertyManagerImpl;

public class SourceNameReader {
	private String configFilePath;
	private String sourceNameProperty;
	
	public SourceNameReader(String configFilePath, String sourceNameProperty){
		this.configFilePath=configFilePath;
		this.sourceNameProperty=sourceNameProperty;
	}
	
	public String read () throws IOException {
		PropertyManager propertyManager=new PropertyManagerImpl();
		propertyManager.setPropertiesSourceFile(configFilePath);
		String applianceFilePath=propertyManager.getProperty(sourceNameProperty);
		return applianceFilePath;
	}
	
	public String getConfigFilePath() {
		return configFilePath;
	}
	public void setConfigFilePath(String configFilePath) {
		this.configFilePath = configFilePath;
	}
	public String getSourceNameProperty() {
		return sourceNameProperty;
	}
	public void setSourceNamePropertyKey(String sourceNameProperty) {
		this.sourceNameProperty = sourceNameProperty;
	}
	
	
}
