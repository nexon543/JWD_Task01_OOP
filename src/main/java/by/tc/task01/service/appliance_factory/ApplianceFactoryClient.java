package by.tc.task01.entity.factory;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.ApplianceType;


public class ApplianceFactoryClient {
	
	private Map <ApplianceType, AbstractApplianceFactory> factoryMap=new HashMap();
	
	public Appliance getAppliance (Map <String, String> applianceProperties){
		Appliance appliance=null;
		
		//How to resolve constant, Parser?
		ApplianceType applianceType=ApplianceType.getApplianceType(applianceProperties.get("applianceType"));
		AbstractApplianceFactory applianceFactory; 
		//FactoryNotFoundException
		applianceFactory=factoryMap.get(applianceType);
		if (applianceFactory!=null)
			appliance=applianceFactory.getAppliance(applianceProperties);
		
		return appliance;
	}
	
	public void addFactroy(ApplianceType type, AbstractApplianceFactory factory){
		factoryMap.put(type, factory);
	}
}
