package by.tc.task01.dao.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.ApplianceType;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.appliance_factory.ApplianceFactoryClient;
import by.tc.task01.service.appliance_factory.LaptopFactory;
import by.tc.task01.util.appliance_parser.ApplianceRecordParser;
import by.tc.task01.util.appliance_parser.ApplianceRecordParserImpl;
import by.tc.task01.util.source_reader.SourceApplianceReader;

public class ApplianceDAOImpl implements ApplianceDAO{

	ApplianceRecordParser applianceRecordParser;
	SourceApplianceReader sourceApplianceReader;
	ApplianceFactoryClient applianceFactoryClient;
	
	
	public ApplianceDAOImpl() throws IOException {
		
		applianceRecordParser=new ApplianceRecordParserImpl();
		applianceFactoryClient=new ApplianceFactoryClient();
		applianceFactoryClient.addFactroy(ApplianceType.LAPTOP, new LaptopFactory());
	}
	

	public <E> List<Appliance> find(Criteria<E> criteria) throws IOException {
		sourceApplianceReader=new SourceApplianceReader();
		List<Appliance> applianceList=new ArrayList<Appliance>();
		String applianceRecord;
		while ((applianceRecord=sourceApplianceReader.read())!=null){
			if(!applianceRecord.trim().equals("")){
				Map <String, String> applianceProperties=applianceRecordParser.parse(applianceRecord);
				
				boolean isValid=criteria.checkApplianceCriteria(applianceProperties);
				if (isValid){
					Appliance appliance=applianceFactoryClient.getAppliance(applianceProperties);
					applianceList.add(appliance);
				}
			}
		}
		sourceApplianceReader.close();
		return applianceList;
	}
	
}