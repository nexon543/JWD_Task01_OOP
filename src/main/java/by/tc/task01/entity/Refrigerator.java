package by.tc.task01.entity;

public class Refrigerator extends Appliance{
	private int powerConsumption;
	private int weight;
	private int freezCapacity;
	private int overallCapacity;
	private int height;
	private int width;

	public Refrigerator(){}
	public int getPowerConsumption() {
		return powerConsumption;
	}
	public void setPowerConsumption(int powerConsumption) {
		this.powerConsumption = powerConsumption;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getFreezCapacity() {
		return freezCapacity;
	}
	public void setFreezCapacity(int freezCapacity) {
		this.freezCapacity = freezCapacity;
	}
	public int getOverallCapacity() {
		return overallCapacity;
	}
	public void setOverallCapacity(int overallCapacity) {
		this.overallCapacity = overallCapacity;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + freezCapacity;
		result = prime * result + height;
		result = prime * result + overallCapacity;
		result = prime * result + powerConsumption;
		result = prime * result + weight;
		result = prime * result + width;
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
		Refrigerator other = (Refrigerator) obj;
		if (freezCapacity != other.freezCapacity)
			return false;
		if (height != other.height)
			return false;
		if (overallCapacity != other.overallCapacity)
			return false;
		if (powerConsumption != other.powerConsumption)
			return false;
		if (weight != other.weight)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Refrigerator [powerConsumption=" + powerConsumption + ", weight=" + weight + ", freezCapacity="
				+ freezCapacity + ", overallCapacity=" + overallCapacity + ", height=" + height + ", width=" + width
				+ "]";
	}
	
	
	
}
