package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.CriteriaValueType;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;
import java.util.Set;

public class Validator {

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {

        String applianceTypeName = String.valueOf(criteria.getApplianceType());

        boolean isValidAppliance = validateApplianceTypeName(applianceTypeName.toUpperCase()) && validateDataType(criteria);
        if (!isValidAppliance)
            return false;
        return true;
    }

    private static boolean validateApplianceTypeName(String applianceType) {
        try {
            SearchCriteria.ApplianceTypes.valueOf(applianceType);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    private static <E> boolean validateDataType(Criteria<E> criteria) {
        Set<Map.Entry<E, Object>> criteriaSet = criteria.getCriteria().entrySet();
        for (Map.Entry<E, Object> criteriaEntry : criteriaSet) {
            if (CriteriaValueType.valueOf(criteriaEntry.getValue().getClass().getSimpleName().toUpperCase()) == null) {
                return false;
            }
        }
        return true;
    }
}
