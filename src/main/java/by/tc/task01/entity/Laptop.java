package by.tc.task01.entity;

import java.util.Map;

public class Laptop implements Appliance{
	int batteryCapacity;
	int weight;
	String os;
	int memoryRom;
	float cpu;
	int displayInches;
	
	public static Laptop create(Map<String, String> properties) {
		Laptop laptop=new Laptop();
		laptop.setBatteryCapacity(Integer.parseInt(properties.get("BATTERY_CAPACITY")));
		return laptop;
	}
	
	
	public int getBatteryCapacity() {
		return batteryCapacity;
	}


	public void setBatteryCapacity(int batteryCapacity) {
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
		result = prime * result + battery_capacity;
		result = prime * result + Float.floatToIntBits(cpu);
		result = prime * result + display_inches;
		result = prime * result + memory_rom;
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
		if (battery_capacity != other.battery_capacity)
			return false;
		if (Float.floatToIntBits(cpu) != Float.floatToIntBits(other.cpu))
			return false;
		if (display_inches != other.display_inches)
			return false;
		if (memory_rom != other.memory_rom)
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
		return "Laptop [battery_capacity=" + battery_capacity + ", weight=" + weight + ", os=" + os + ", memory_rom="
				+ memory_rom + ", cpu=" + cpu + ", display_inches=" + display_inches + "]";
	}
	
	
}
