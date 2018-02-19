package by.tc.task01.entity.factory;


import java.util.Map;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;

public class ApplianceFactory {
	
	private static final ApplianceFactory instance=new ApplianceFactory();
	
	private ApplianceFactory() {}
	
	public Appliance getAppliance(Map<String, String> properties) {
		ApplianceType applianceType=ApplianceType.getApplianceType(properties.get("applianceType"));
		Appliance appliance=null;
		switch (applianceType) {
		case LAPTOP: 
			appliance=new Laptop();
			appliance.initFieldsByProperties(properties);
			break;
		case OVEN: 
			appliance=new Oven();
			appliance.initFieldsByProperties(properties);
			break;
		case REFREGERATOR:
			appliance=new Refrigerator();
			appliance.initFieldsByProperties(properties);
		default: throw new EnumConstantNotPresentException(ApplianceType.class, properties.get("applianceType"));
		}
		
		return appliance;
	}
	
	public static ApplianceFactory getInstance() {
		return instance;
	}
}
