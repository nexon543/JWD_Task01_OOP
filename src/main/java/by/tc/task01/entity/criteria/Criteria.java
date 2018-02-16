package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import by.tc.task01.entity.Appliance;

public class Criteria<E> {
	
	public final int MORE=-1;
	public final int LESS=1;
	public final int EQUALS=0;
	private int compareCondition=EQUALS;
	
	private String applianceType;

	private Map<E, Object> criteria = new HashMap<E, Object>();

	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	public String getApplianceType() {
		return applianceType;
	}

	public void setApplianceType(String applianceType) {
		this.applianceType = applianceType;
	}
		
	
	public void setCompareCondition (int compareCondition) {
		this.compareCondition=compareCondition;
	}
	
	public boolean checkApplianceCriteria(Map<String, String> properties) {
		if (!properties.get("applianceType").equals(applianceType))
			return false;
		boolean result=true;
		Set<Entry<E, Object>> criterias=criteria.entrySet();
		for (Entry<E, Object> criteria:criterias) {
			String criteriaName=criteria.getKey().toString();
			checkCriteria(properties.get(criteriaName), criteria.getValue());
		}
		
		return result;
	}

	private boolean checkCriteria(String applianceValue, Object criteriaValue) {
		System.out.println(criteriaValue.getClass().toString());
		return true;
	}
}
