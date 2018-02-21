package by.tc.task01.service.appliance_factory;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import by.tc.task01.entity.Appliance;

public abstract class AbstractApplianceFactory {

	Map <String, String> propertyFieldType;
	Appliance applianceInstance;
	
	public void initFieldsByProperties(Map<String, String> applianceProperties) {
		
		Iterator <Entry<String, String>> propertyEntries=applianceProperties.entrySet().iterator();
		
		while(propertyEntries.hasNext()){
			Entry<String, String> property=propertyEntries.next();
			setApplianceField(property.getKey(), property.getValue());
		}
	}
	
	protected float getFloat(String value){
		return Float.parseFloat(value);
	}
	protected int getInt(String value){
		return Integer.parseInt(value);
	}
	public abstract Appliance getAppliance(Map<String, String> properties);
	public abstract void setApplianceField(String propertyName, String propertyValue);
}
