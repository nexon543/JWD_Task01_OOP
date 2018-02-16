package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.parsing.ApplianceRecordParserImpl;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.factory.ApplianceFactory;
import by.tc.task01.util.PropertyManager;
import by.tc.task01.util.PropertyManagerImpl;

public class ApplianceDAOImpl implements ApplianceDAO, AutoCloseable{

	ApplianceFactory applianceFactory;
	ApplianceRecordParser applianceRecordParser;
	SourceApplianceReader sourceApplianceReader;
	{
		sourceApplianceReader=new SourceApplianceReader();
		applianceRecordParser=new ApplianceRecordParserImpl();
	}
	
	public <E> List<Appliance> find(Criteria<E> criteria) throws IOException {
		List<Appliance> appliances=new ArrayList<Appliance>();
		String applianceRecord;
		while ((applianceRecord=sourceApplianceReader.read())!=null){
			applianceRecordParser(applianceRecord);
			
		}
		return appliances;
	}


	@Override
	public void close() throws Exception {
		sourceApplianceReader.close();
		
	}
}



class SourceNameReader {
	public String read () {
		String applianceDBPath=null;
		try {
			PropertyManager pm=new PropertyManagerImpl();
			pm.setPropertiesSourceFile("config.properties");
			applianceDBPath=pm.getProperty("applianceDBFile");
			System.out.println(applianceDBPath);
			
		}
		catch (Exception ex) {}
		return applianceDBPath;
	}
}

class SourceApplianceReader implements Closeable {
	private String sourceName;
	private BufferedReader fileReader;
	
	{ 
		SourceNameReader snr=new SourceNameReader();
		sourceName=snr.read();
		System.out.println(sourceName);
		try {
			fileReader=new BufferedReader (new FileReader(sourceName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public String read() throws IOException {
		if (fileReader == null) {
			throw new FileNotFoundException();
		}
		return fileReader.readLine();
	}
	
	
	public void close() throws IOException {
		fileReader.close();
		
	}
}

class ApplianceRecordParser {
	
}