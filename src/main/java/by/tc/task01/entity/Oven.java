package by.tc.task01.entity;

import java.util.Map;

public class Oven extends Appliance{
	int powerConsumption;
	int weight;
	int depth;
	int capacity;
	float height;
	float width;
	
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
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	@Override
	public String toString() {
		return "Oven [powerConsumption=" + powerConsumption + ", weight=" + weight + ", depth=" + depth + ", capacity="
				+ capacity + ", height=" + height + ", width=" + width + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + depth;
		result = prime * result + Float.floatToIntBits(height);
		result = prime * result + powerConsumption;
		result = prime * result + weight;
		result = prime * result + Float.floatToIntBits(width);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Oven))
			return false;
		Oven other = (Oven) obj;
		if (capacity != other.capacity)
			return false;
		if (depth != other.depth)
			return false;
		if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height))
			return false;
		if (powerConsumption != other.powerConsumption)
			return false;
		if (weight != other.weight)
			return false;
		if (Float.floatToIntBits(width) != Float.floatToIntBits(other.width))
			return false;
		return true;
	}

	
	
}
