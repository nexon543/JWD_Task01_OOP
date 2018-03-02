package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {

    public static final int MORE = -1;
    public static final int LESS = 1;
    public static final int EQUALS = 0;
    private ApplianceType applianceType;
    private Map<E, Object> criteria = new HashMap<E, Object>();
    private Map<E, Integer> compareCondition = new HashMap<E, Integer>();

    public void add(E searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    public void add(E searchCriteria, Object value, int compareCondition) {
        criteria.put(searchCriteria, value);
        addCompareCondition(searchCriteria, compareCondition);
    }

    public ApplianceType getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(ApplianceType applianceType) {
        this.applianceType = applianceType;
    }

    public void addCompareCondition(E criteria, int compareConditionValue) {
        compareCondition.put(criteria, compareConditionValue);
    }

    public int getCompareCondition(E criteria) {
        Integer result = compareCondition.get(criteria);
        if (result == null)
            return 0;
        return result;
    }

    public Map<E, Object> getCriteria() {
        return criteria;
    }
}
