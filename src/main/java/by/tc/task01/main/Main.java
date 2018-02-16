package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import java.util.List;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.impl.ApplianceDAOImpl;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria<Oven> criteriaOven = new Criteria<Oven>();
		criteriaOven.setApplianceType("Oven");
		criteriaOven.add(Oven.CAPACITY, 3);
		criteriaOven.add(Oven.DEPTH, 3);

		appliances = service.find(criteriaOven);
		for (Appliance appliance:appliances) {
		if(appliance.getClass() == by.tc.task01.entity.Oven.class) {}
		by.tc.task01.entity.Oven oven = (by.tc.task01.entity.Oven) appliance;
		PrintApplianceInfo.print(oven);
		}

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

	}

}
