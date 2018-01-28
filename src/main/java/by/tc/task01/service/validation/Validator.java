package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.entity.criteria.SearchCriteria.ApplianceTypes;

public class Validator {

	public static <E> boolean criteriaValidator(Criteria<E> criteria) {

		String applianceTypeName=criteria.getApplianceType();
		boolean isValidAppliance=checkApplianceTypeName(applianceTypeName.toUpperCase());
		if (!isValidAppliance)
			return false;
		return true;
	}

	private static boolean checkApplianceTypeName(String applianceType) {
		try
		{
			ApplianceTypes aType=SearchCriteria.ApplianceTypes.valueOf(applianceType);
			return true;
		}
		catch (IllegalArgumentException ex) {
			return false;
		}
	}

}
