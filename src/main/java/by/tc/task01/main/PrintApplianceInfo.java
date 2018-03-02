package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {

    public static void print(Appliance appliance) {
        System.out.println(appliance.toString());

    }

    public static void printAll(List<Appliance> appliances) {
        for (Appliance appliance : appliances) {
            PrintApplianceInfo.print(appliance);
        }
    }

}
