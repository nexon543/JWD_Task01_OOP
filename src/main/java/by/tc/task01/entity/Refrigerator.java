package by.tc.task01.entity;

public class Refrigerator implements Appliance{
	int power_consumption;
	int weight;
	int freez_capacity;
	int overall_capacity;
	int height;
	int width;
	public int getPower_consumption() {
		return power_consumption;
	}
	public void setPower_consumption(int power_consumption) {
		this.power_consumption = power_consumption;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getFreez_capacity() {
		return freez_capacity;
	}
	public void setFreez_capacity(int freez_capacity) {
		this.freez_capacity = freez_capacity;
	}
	public int getOverall_capacity() {
		return overall_capacity;
	}
	public void setOverall_capacity(int overall_capacity) {
		this.overall_capacity = overall_capacity;
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
	public String toString() {
		return "Refrigerator [power_consumption=" + power_consumption + ", weight=" + weight + ", freez_capacity="
				+ freez_capacity + ", overall_capacity=" + overall_capacity + ", height=" + height + ", width=" + width
				+ "]";
	}
	
}
