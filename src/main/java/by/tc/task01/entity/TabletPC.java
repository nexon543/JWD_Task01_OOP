package by.tc.task01.entity;

public class TabletPC implements Appliance{
	int battery_capacity;
	int display_inches;
	int memory_rom;
	int flash_memory_capacity;
	String colour;
	public int getBattery_capacity() {
		return battery_capacity;
	}
	public void setBattery_capacity(int battery_capacity) {
		this.battery_capacity = battery_capacity;
	}
	public int getDisplay_inches() {
		return display_inches;
	}
	public void setDisplay_inches(int display_inches) {
		this.display_inches = display_inches;
	}
	public int getMemory_rom() {
		return memory_rom;
	}
	public void setMemory_rom(int memory_rom) {
		this.memory_rom = memory_rom;
	}
	public int getFlash_memory_capacity() {
		return flash_memory_capacity;
	}
	public void setFlash_memory_capacity(int flash_memory_capacity) {
		this.flash_memory_capacity = flash_memory_capacity;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	@Override
	public String toString() {
		return "TabletPC [battery_capacity=" + battery_capacity + ", display_inches=" + display_inches + ", memory_rom="
				+ memory_rom + ", flash_memory_capacity=" + flash_memory_capacity + ", colour=" + colour + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + battery_capacity;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + display_inches;
		result = prime * result + flash_memory_capacity;
		result = prime * result + memory_rom;
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
		TabletPC other = (TabletPC) obj;
		if (battery_capacity != other.battery_capacity)
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (display_inches != other.display_inches)
			return false;
		if (flash_memory_capacity != other.flash_memory_capacity)
			return false;
		if (memory_rom != other.memory_rom)
			return false;
		return true;
	}
	
}
