package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.entity.criteria.SearchCriteria.ApplianceTypes;

public class Validator {

	public static <E> boolean criteriaValidator(Criteria<E> criteria) {

		String applianceTypeName=criteria.getApplianceType();
		boolean isValidAppliance=checkApplianceTypeName(applianceTypeName.toUpperCase());
		// check Appliance Type Name - если читать имя метод правильно - именатор проверящего электротоварного типа
		// если вкладывая твою логику - проверить ТИП ИМЕНИ(названия) электротовара - зачем мне проверять тип того, как называется товар?
		if (!isValidAppliance)
			return false;// { } где, или Code Convention - это не твое?
		return true;
	}

	private static boolean checkApplianceTypeName(String applianceType) {
		try
		{
			ApplianceTypes aType=SearchCriteria.ApplianceTypes.valueOf(applianceType);// логику валидации перенес в сущность - зачем?
			// а если правила валидации параметров изменятся?
			return true;
		}
		catch (IllegalArgumentException ex) {
			return false;
		}
	}

}
