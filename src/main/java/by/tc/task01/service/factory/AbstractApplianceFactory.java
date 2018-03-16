package by.tc.task01.service.factory;

import by.tc.task01.entity.Appliance;
import by.tc.task01.service.validation.Validator;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class AbstractApplianceFactory {

    protected Appliance applianceInstance;

    public void initFieldsByProperties(Map<String, String> applianceProperties) {

        Iterator<Entry<String, String>> propertyEntries = applianceProperties.entrySet().iterator();

        while (propertyEntries.hasNext()) {
            Entry<String, String> property = propertyEntries.next();
            if (!Validator.isUnpairedPropertyName(property.getKey())) {
                setApplianceField(property.getKey(), property.getValue());
            }
        }
    }

    protected float getFloat(String value) {
        return Float.parseFloat(value);
    }

    protected int getInt(String value) {
        return Integer.parseInt(value);
    }

    public abstract Appliance getAppliance(Map<String, String> properties);

    protected abstract void setApplianceField(String propertyName, String propertyValue);
}
