package by.tc.task01.main;



import java.util.List;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////
		
		Criteria<SearchCriteria.Laptop> criteriaLaptop = new Criteria<SearchCriteria.Laptop>();
		criteriaLaptop.setApplianceType("Laptop");
		criteriaLaptop.add(SearchCriteria.Laptop.BATTERY_CAPACITY, 1);
		criteriaLaptop.add(SearchCriteria.Laptop.CPU, 1.2);
		appliances = service.find(criteriaLaptop);

		PrintApplianceInfo.printAll(appliances);
		
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
