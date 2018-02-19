package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Laptop extends Appliance{
	float batteryCapacity;
	int weight;
	String os;
	int memoryRom;
	float cpu;
	int displayInches;
	
	static {
		propertyFieldType=new HashMap<String, String>();
		propertyFieldType.put("BATTERY_CAPACITY", "float");
		propertyFieldType.put("WEIGHT", "int");
		propertyFieldType.put("OS", "String");
		propertyFieldType.put("MEMORY_ROM", "int");
		propertyFieldType.put("DISPLAY_INCHES", "int");
		propertyFieldType.put("CPU", "float");
		
	}
	
	public static Appliance create() {
		return new Laptop();
	}
	protected void setInt (String fieldName, int value) {
		switch(fieldName) {
		
		case "WEIGHT":this.weight=value;
		break;
		case "MEMORY_ROM":this.memoryRom=value;
		break;
		case "DISPLAY_INCHES":this.displayInches=value;
		}
	}
	protected void setFloat (String fieldName, float value) {
		switch(fieldName) {
			case "BATTERY_CAPACITY":this.batteryCapacity=value;
			break;
			case "CPU": this.cpu=value;
		}
	}
	protected void setString (String fieldValue, String value) {
		 this.os=value;
	}
	
	public float getBatteryCapacity() {
		return batteryCapacity;
	}


	public void setBatteryCapacity(float batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}


	public int getMemoryRom() {
		return memoryRom;
	}


	public void setMemoryRom(int memoryRom) {
		this.memoryRom = memoryRom;
	}


	public int getDisplayInches() {
		return displayInches;
	}


	public void setDisplayInches(int displayInches) {
		this.displayInches = displayInches;
	}


	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	
	public float getCpu() {
		return cpu;
	}
	public void setCpu(float cpu) {
		this.cpu = cpu;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int)batteryCapacity;
		result = prime * result + Float.floatToIntBits(cpu);
		result = prime * result + displayInches;
		result = prime * result + memoryRom;
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + weight;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		if (batteryCapacity != other.batteryCapacity)
			return false;
		if (Float.floatToIntBits(cpu) != Float.floatToIntBits(other.cpu))
			return false;
		if (displayInches != other.displayInches)
			return false;
		if (memoryRom != other.memoryRom)
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Laptop [batteryCapacity=" + batteryCapacity + ", weight=" + weight + ", os=" + os + ", memoryRom="
				+ memoryRom + ", cpu=" + cpu + ", displayInches=" + displayInches + "]";
	}
	
	
	
	
}
