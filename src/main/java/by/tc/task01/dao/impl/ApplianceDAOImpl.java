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
import by.tc.task01.dao.parsing.ApplianceRecordParser;
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

	public ApplianceDAOImpl() throws IOException {
		sourceApplianceReader=new SourceApplianceReader();
		applianceRecordParser=new ApplianceRecordParserImpl();
		applianceFactory=ApplianceFactory.getInstance();
	}
	
	public <E> List<Appliance> find(Criteria<E> criteria) throws IOException {
		List<Appliance> appliances=new ArrayList<Appliance>();
		String applianceRecord;
		while ((applianceRecord=sourceApplianceReader.read())!=null){
			if(!applianceRecord.trim().equals("")){
				Map <String, String> applianceProperties=applianceRecordParser.parse(applianceRecord);
				Appliance appliance=applianceFactory.getAppliance(applianceProperties);
				if (appliance!=null)
					appliances.add(appliance);
			}
		}
		return appliances;
	}

	public void close() throws Exception {
		sourceApplianceReader.close();
	}
}



class SourceNameReader {
	public String read () throws IOException   {
		String applianceDBPath=null;
		PropertyManager pm=new PropertyManagerImpl();
		pm.setPropertiesSourceFile("config.properties");
		applianceDBPath=pm.getProperty("applianceDBFile");
		System.out.println(applianceDBPath);
		return applianceDBPath;
	}
}

class SourceApplianceReader implements Closeable {
	private String sourceName;
	private BufferedReader fileReader;
	
	public SourceApplianceReader()  throws IOException {
		SourceNameReader snr=new SourceNameReader();
		sourceName=snr.read();
		FileReader fr = new FileReader(sourceName);
		fileReader=new BufferedReader (fr);
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