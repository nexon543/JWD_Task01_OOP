package by.tc.task01.entity.factory;


import static by.tc.task01.entity.criteria.SearchCriteria.Laptop;

import java.util.Map;
import by.tc.task01.entity.Appliance;


public class LaptopFactory extends AbstractApplianceFactory {

	by.tc.task01.entity.Laptop laptopInstance;
	@Override
	public Appliance getAppliance(Map<String, String> properties) {
		laptopInstance=new by.tc.task01.entity.Laptop();
		applianceInstance=laptopInstance;
		initFieldsByProperties(properties);
		return applianceInstance;
	}

	@Override
	public void setApplianceField(String propertyName, String propertyValue) {
		//Exception invalide propertyName
		try{
		Laptop laptopPropertyEnum=Laptop.valueOf(propertyName);
		
		if (laptopPropertyEnum!=null){
		switch (laptopPropertyEnum){
			case BATTERY_CAPACITY:laptopInstance.setBatteryCapacity(getFloat(propertyValue));
			break;
			case CPU:
				laptopInstance.setCpu(getFloat(propertyValue));
			break;
			case OS:
				laptopInstance.setOs(propertyValue);
			break;
			case MEMORY_ROM: 
				laptopInstance.setMemoryRom(getInt(propertyValue));
			break;
			case SYSTEM_MEMORY: 
				laptopInstance.setSystemMemory(getInt(propertyValue));
				break;
			case WEIGHT: 
			
		default:
			break;
		}
		}
		}
		catch (IllegalArgumentException ex){//Logger}
		
	}

	}
}
