package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.ApplianceType;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;
import java.util.Set;

public class CriteriaChecker {



    public <E> boolean checkApplianceCriteria(Map<String, String> applianceProperties, ApplianceType applianceType, Criteria <E> criteria) {
        if (!applianceProperties.get(applianceType.name()).equals(applianceType))
            return false;
        Set<Map.Entry<E, Object>> criteriaSet=criteria.entrySet();
        //iteration through all criterias
        for (Map.Entry<E, Object> criteriaEntry:criteriaSet) {
            E criteriaKey=(E)criteriaEntry.getKey();
            String criteriaName=criteriaKey.toString();
            int compareCondition=getCompareCondition(criteriaKey);
            Object criteriaValue=criteriaEntry.getValue();
            //checking value of appliance property associated with current criteria by criteriaName
            if (!checkSingleCriteria (criteriaValue, compareCondition, properties.get(criteriaName)))
                return false;
        }

        return true;
    }

    private boolean checkSingleCriteria(Object criteriaValue, int compareCondition, String applianceFieldValue) {
        Criteria.CriteriaValueType valueType=getCriteriaValueType(criteriaValue);
        if (valueType != null)
            switch (valueType){
                case INTEGER:
                    //Illegal criteria type exception
                    int applianceIntFieldValue=Integer.parseInt(applianceFieldValue);
                    return checkInt((Integer)criteriaValue, compareCondition, applianceIntFieldValue);
                case FLOAT:
                    float applianceFloatFieldValue=Float.parseFloat(applianceFieldValue+"f");
                    return checkFloat((Float)criteriaValue, compareCondition, applianceFloatFieldValue);
                case STRING:
                    return checkString((String)criteriaValue, applianceFieldValue);
                default://TODO: add Logger
            }
        System.out.println("Checking criteria "+criteriaValue.getClass().toString());
        return true;
    }

    private static Criteria.CriteriaValueType getCriteriaValueType(Object criteriaValue){
        String className=criteriaValue.getClass().getSimpleName();
        return criteriaValueType.get(className);
    }

    private static boolean checkInt(Integer criteriaValue, int compareCondition, int applianceValue){
        return criteriaValue.compareTo(applianceValue)==compareCondition;
    }

    private static boolean checkFloat(Float criteriaValue, int compareCondition, float applianceValue){
        return criteriaValue.compareTo(applianceValue)==compareCondition;
    }

    private static boolean checkString(String criteriaValue, String applianceValue){
        //TODO: use RegExp
        return criteriaValue.equals(applianceValue);
    }



}
