package by.tc.task01.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyManagerImpl implements PropertyManager, AutoCloseable {// оставлю этот класс без комментариев
	private String propertiesFilePath="config.properties";
	InputStream input;
	private Properties appProperties = new Properties();
	
	private void readPropertyFile() throws IOException {
		if (input==null) {
			input=new FileInputStream(propertiesFilePath);
		}
		appProperties.load(input);
	}
	
	public String getProperty(String key) {
		return appProperties.getProperty(key);
	}
	
	public  void setProperty(String key, String value) {
		appProperties.setProperty(key, value);
	}

	@Override
	public void setPropertiesSourceFile (String propertiesFilePath) throws IOException {
		if (input != null) {
			input.close();
		}
		this.propertiesFilePath=propertiesFilePath;
		readPropertyFile();
		
	}

	@Override
	public void close() throws Exception {
		input.close();
		
	}

	
}
