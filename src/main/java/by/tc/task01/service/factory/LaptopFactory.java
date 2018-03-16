package by.tc.task01.service.factory;


import by.tc.task01.entity.Appliance;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import static by.tc.task01.entity.criteria.SearchCriteria.Laptop;


public class LaptopFactory extends AbstractApplianceFactory {

    by.tc.task01.entity.Laptop laptopInstance;

    private Map <Laptop, Consumer<String>> setApplianceFieldActions=new EnumMap<>(Laptop.class);
    private String propertyValue;

    public LaptopFactory (){
        setApplianceFieldActions.put(Laptop.BATTERY_CAPACITY, s->laptopInstance.setBatteryCapacity(getFloat(propertyValue)));
        setApplianceFieldActions.put(Laptop.OS, s->laptopInstance.setOs(propertyValue));
        setApplianceFieldActions.put(Laptop.CPU, s->laptopInstance.setCpu(getFloat(propertyValue)));
        setApplianceFieldActions.put(Laptop.MEMORY_ROM, s->laptopInstance.setMemoryRom(getInt(propertyValue)));
        setApplianceFieldActions.put(Laptop.SYSTEM_MEMORY, s->laptopInstance.setSystemMemory(getInt(propertyValue)));
    }
    @Override
    public Appliance getAppliance(Map<String, String> properties) {
        laptopInstance = new by.tc.task01.entity.Laptop();
        applianceInstance = laptopInstance;
        initFieldsByProperties(properties);
        return applianceInstance;
    }

    @Override
    public void setApplianceField(String propertyName, String propertyValue) {
        this.propertyValue=propertyValue;
        Optional.ofNullable(propertyName).filter(propName->setApplianceFieldActions.containsKey(Laptop.valueOf(propName))).
                ifPresent(propN->setApplianceFieldActions.get(Laptop.valueOf(propN)).accept(propN));

    }
}
