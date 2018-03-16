package by.tc.task01.main;


import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.ApplianceType;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.service.exception.ServiceException;
import by.tc.task01.service.validation.Validator;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service;
        service = factory.getApplianceService();

        List<Appliance> appliances;

        //////////////////////////////////////////////////////////////////

        Criteria<SearchCriteria.Laptop> criteriaLaptop = new Criteria<>();
        criteriaLaptop.setApplianceType(ApplianceType.LAPTOP);
        criteriaLaptop.add(SearchCriteria.Laptop.BATTERY_CAPACITY, 1f);
        criteriaLaptop.add(SearchCriteria.Laptop.CPU, 1.2);
        Validator.criteriaValidator(criteriaLaptop);
        try {
            appliances = service.find(criteriaLaptop);
            PrintApplianceInfo.printAll(appliances);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("---------------------------------------------");
        criteriaLaptop.add(SearchCriteria.Laptop.BATTERY_CAPACITY, 1f,Criteria.MORE);
        criteriaLaptop.add(SearchCriteria.Laptop.CPU, 1.2, Criteria.MORE);
        Validator.criteriaValidator(criteriaLaptop);
        try {
            appliances = service.find(criteriaLaptop);
            PrintApplianceInfo.printAll(appliances);
        } catch (ServiceException ex) {
            System.out.println("service error code: "+ex.gerErrorCode());
        }

		/*Criteria<Oven> criteriaOven = new Criteria<Oven>();
		criteriaOven.setApplianceType("Oven");
		criteriaOven.add(Oven.CAPACITY, 3);
		criteriaOven.add(Oven.DEPTH, 3);

		appliances = service.find(criteriaOven);
		PrintApplianceInfo.printAll(appliances);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria<Oven>();
		criteriaOven.add(Oven.HEIGHT, 200);
		criteriaOven.add(Oven.DEPTH, 300);

		appliances = service.find(criteriaOven);

		for (Appliance appliance:appliances) {
			PrintApplianceInfo.print(appliance);
		}

		//////////////////////////////////////////////////////////////////
		
		Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>();
		criteriaTabletPC.add(TabletPC.COLOR, "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM, 4);


		appliances = service.find(criteriaTabletPC);

		for (Appliance appliance:appliances) {
			PrintApplianceInfo.print(appliance);
		}
*/
    }

}
