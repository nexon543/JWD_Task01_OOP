package by.tc.task01.entity.factory;


import java.util.Map;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;

public class ApplianceFactory {
	
	private static final ApplianceFactory instance=new ApplianceFactory();
	
	private ApplianceFactory() {}
	
	public Appliance getAppliance(Map<String, String> properties) {
		String applianceName=properties.get("name");
		switch (applianceName) {
		case "Laptop": return Laptop.create(properties);
		default: return null;
		}
	}
}
