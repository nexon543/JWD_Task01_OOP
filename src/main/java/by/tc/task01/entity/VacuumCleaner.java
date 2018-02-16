package by.tc.task01.entity;

public class VacuumCleaner implements Appliance{
	int power_consumption;
	char filter_type;
	int bag_type;
	String wand_type;
	int motor_speed_regulation;
	int cleaning_width;
	public int getPower_consumption() {
		return power_consumption;
	}
	public void setPower_consumption(int power_consumption) {
		this.power_consumption = power_consumption;
	}
	public char getFilter_type() {
		return filter_type;
	}
	public void setFilter_type(char filter_type) {
		this.filter_type = filter_type;
	}
	public int getBag_type() {
		return bag_type;
	}
	public void setBag_type(int bag_type) {
		this.bag_type = bag_type;
	}
	public String getWand_type() {
		return wand_type;
	}
	public void setWand_type(String wand_type) {
		this.wand_type = wand_type;
	}
	public int getMotor_speed_regulation() {
		return motor_speed_regulation;
	}
	public void setMotor_speed_regulation(int motor_speed_regulation) {
		this.motor_speed_regulation = motor_speed_regulation;
	}
	public int getCleaning_width() {
		return cleaning_width;
	}
	public void setCleaning_width(int cleaning_width) {
		this.cleaning_width = cleaning_width;
	}
	public int hashCode () {
		int result=1;
		int prime=43;
		
		result=result*prime+((wand_type!=null)?0:wand_type.hashCode());
		result=result*prime+power_consumption;
		result=result*prime+filter_type;
		result=result*prime+motor_speed_regulation;
		
		return result;
	}
}
