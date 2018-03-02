package by.tc.task01.service.appliance_factory;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.ApplianceType;
import by.tc.task01.util.appliance_parser.ParserParameter;

import java.util.HashMap;
import java.util.Map;


public class ApplianceFactoryClient {

    private Map<ApplianceType, AbstractApplianceFactory> factoryMap = new HashMap();

    public Appliance getAppliance(Map<String, String> applianceProperties) {
        Appliance appliance = null;
        ApplianceType applianceType = ApplianceType.valueOf(applianceProperties.get(ParserParameter.APPLIANCE_TYPE_KEY));
        AbstractApplianceFactory applianceFactory;
        applianceFactory = factoryMap.get(applianceType);
        if (applianceFactory != null)
            appliance = applianceFactory.getAppliance(applianceProperties);

        return appliance;
    }

    public void addFactroy(ApplianceType type, AbstractApplianceFactory factory) {
        factoryMap.put(type, factory);
    }
}
