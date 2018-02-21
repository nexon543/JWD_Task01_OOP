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
			return null; // к моменту написания тобой этого кода мы уже разобрались с исключччениями
		}
		List<Appliance> appliances=new ArrayList<Appliance>();
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		try {
			appliances = applianceDAO.find(criteria);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// счто это за обработка? Ты зачем гасишь исключение, не говоря вызывающему коду, что у тебя что-то слудилось
			// возврат пустого списка означает, что таких товар не найдено - штатная ситуация, а не что при выполнении кода что-то пошло не так...
		}
		
		return appliances;
	}

}
