package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.CriteriaValueType;
import by.tc.task01.util.parser.ParserParameter;

import java.util.Map;
import java.util.Set;

public class CriteriaChecker {
    private static boolean checkInt(Integer criteriaValue, int compareCondition, int applianceValue) {
        return criteriaValue.compareTo(applianceValue) == compareCondition;
    }

    private static boolean checkFloat(Float criteriaValue, int compareCondition, float applianceValue) {
        return criteriaValue.compareTo(applianceValue) == compareCondition;
    }

    private static boolean checkString(String criteriaValue, String applianceValue) {
        //TODO: use RegExp
        return criteriaValue.equals(applianceValue);
    }

    private static boolean checkDouble(Double criteriaValue, int compareCondition, double applianceValue) {
        return criteriaValue.compareTo(applianceValue) == compareCondition;
    }

    public <E> boolean check(Map<String, String> applianceProperties, Criteria<E> criteria) {
        String propertyApplianceType = applianceProperties.get(ParserParameter.APPLIANCE_TYPE_KEY).toUpperCase();
        if (!propertyApplianceType.equals(criteria.getApplianceType().toString()))
            return false;
        Set<Map.Entry<E, Object>> criteriaSet = criteria.getCriteria().entrySet();
        for (Map.Entry<E, Object> criteriaEntry : criteriaSet) {
            E criteriaKey = criteriaEntry.getKey();
            String criteriaName = criteriaKey.toString();
            int compareCondition = criteria.getCompareCondition(criteriaKey);
            Object criteriaValue = criteriaEntry.getValue();
            if (!checkSingleCriteria(criteriaValue, compareCondition, applianceProperties.get(criteriaName)))
                return false;
        }
        return true;
    }

    private boolean checkSingleCriteria(Object criteriaValue, int compareCondition, String applianceFieldValue) {
        CriteriaValueType valueType = CriteriaValueType.valueOf(criteriaValue.getClass().getSimpleName().toUpperCase());
        if (valueType != null)
            switch (valueType) {
                case INTEGER:
                    int applianceIntFieldValue = Integer.parseInt(applianceFieldValue);
                    return checkInt((Integer) criteriaValue, compareCondition, applianceIntFieldValue);
                case FLOAT:
                    float applianceFloatFieldValue = Float.parseFloat(applianceFieldValue + "f");
                    return checkFloat((Float) criteriaValue, compareCondition, applianceFloatFieldValue);
                case DOUBLE:
                    double applianceDoubleFieldValue = Double.parseDouble(applianceFieldValue);
                    return checkDouble((Double) criteriaValue, compareCondition, applianceDoubleFieldValue);
                case STRING:
                    return checkString((String) criteriaValue, applianceFieldValue);
                default://TODO: add Logger
            }
        return true;
    }
}
