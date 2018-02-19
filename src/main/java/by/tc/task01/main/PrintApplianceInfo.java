package by.tc.task01.main;

import java.util.List;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {
	
	public static void print(Appliance appliance) {
		System.out.println(appliance.toString());

	}
	
	public static void printAll(List<Appliance>appliances){
		for (Appliance appliance:appliances) {
			PrintApplianceInfo.print(appliance);
		}
	}

}
