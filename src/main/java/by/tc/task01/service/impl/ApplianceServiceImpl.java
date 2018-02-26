package by.tc.task01.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService{

	public <E> List<Appliance> find(Criteria<E> criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}
		List<Appliance> appliances=new ArrayList<Appliance>();
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
			appliances = applianceDAO.find(criteria);
		return appliances;
	}

}
