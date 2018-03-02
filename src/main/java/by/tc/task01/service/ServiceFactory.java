package by.tc.task01.service;

import by.tc.task01.service.impl.ApplianceServiceImpl;

public final class ServiceFactory {

    private static ServiceFactory instance=new ServiceFactory();
    private ApplianceService applianceService;

    private ServiceFactory() {
        applianceService = new ApplianceServiceImpl();
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ApplianceService getApplianceService() {
        return applianceService;
    }
    public ApplianceService getApplianceService(String applianceFilePath) {
        return applianceService;
    }

}
