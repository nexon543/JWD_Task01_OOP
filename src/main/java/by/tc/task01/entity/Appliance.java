package by.tc.task01.entity;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Appliance {
	
	protected static Map <String, String> propertyFieldType;// что это????
	// Appliance - базовая класс-сущность для иерархии электротоваров, откуда в ней может взяться этот map?
	// и что за фигню делает метод ниже? во-первых - код этого метод - это помесь логики с валидацией данных
	// во-вторых - почему определяются только четыре типа?
	
	public void initFieldsByProperties(Map<String, String> s) {
		Set<Entry<String, String>> entrySet=s.entrySet();
		for (Entry<String, String> e:entrySet) {
		String propertyName=e.getKey();
		String value=e.getValue();
			String fieldType=propertyFieldType.get(propertyName);
			if (fieldType!=null) {
			switch (fieldType) {
			case "int":
				int intValue=Integer.parseInt(value);
				setInt(propertyName, intValue);
				break;
			case "String": 
				setString(propertyName, value);
				break;
			case "float": 
				float floatValue=Float.parseFloat(value);
				setFloat(propertyName,floatValue);
				break;
			case "double":
				double doubleValue=Double.parseDouble(value);
				setDouble(propertyName,doubleValue);
				break;
			default:
			}
			}
		}
	}
	
	protected void setString (String propertyName, String value) {};// эм, а что методы-то делают?
	protected void setInt(String propertyName, int value) {}
	protected void setFloat(String propertyName, float value) {}
	protected void setDouble(String propertyName, double value) {}
}
