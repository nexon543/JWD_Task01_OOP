package by.tc.task01.entity.factory;


import java.util.Map;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;

public class ApplianceFactory {
	
	private static final ApplianceFactory instance=new ApplianceFactory();
	
	private ApplianceFactory() {}
	
	public Appliance getAppliance(Map<String, String> properties) {
		String applianceName=properties.get("applianceType");
		switch (applianceName) {
		case "Laptop": 
			Laptop laptop=new Laptop();
			laptop.initFieldsByProperties(properties);
			return laptop;
		/*case "Oven": 
			Oven oven=new Oven();
			oven.initFieldsByProperties(properties);
			return oven; */
		default: return null;
		}
	}
	
	public static ApplianceFactory getInstance() {
		return instance;
	}
}
