package by.tc.task01.entity;

public class Speakers implements Appliance{
	int power_consumption;
	int number_of_speakers;
	int cord_length;
	float freaquency_range;
	public int getPower_consumption() {
		return power_consumption;
	}
	public void setPower_consumption(int power_consumption) {
		this.power_consumption = power_consumption;
	}
	public int getNumber_of_speakers() {
		return number_of_speakers;
	}
	public void setNumber_of_speakers(int number_of_speakers) {
		this.number_of_speakers = number_of_speakers;
	}
	public int getCord_length() {
		return cord_length;
	}
	public void setCord_length(int cord_length) {
		this.cord_length = cord_length;
	}
	public float getFreaquency_range() {
		return freaquency_range;
	}
	public void setFreaquency_range(float freaquency_range) {
		this.freaquency_range = freaquency_range;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cord_length;
		result = prime * result + Float.floatToIntBits(freaquency_range);
		result = prime * result + number_of_speakers;
		result = prime * result + power_consumption;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj.getClass()!=Speakers.class)
			return false;
		Speakers other = (Speakers) obj;
		if (cord_length != other.cord_length)
			return false;
		if (Float.floatToIntBits(freaquency_range) != Float.floatToIntBits(other.freaquency_range))
			return false;
		if (number_of_speakers != other.number_of_speakers)
			return false;
		if (power_consumption != other.power_consumption)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Speakers [power_consumption=" + power_consumption + ", number_of_speakers=" + number_of_speakers
				+ ", cord_length=" + cord_length + ", freaquency_range=" + freaquency_range + "]";
	}
	
}
