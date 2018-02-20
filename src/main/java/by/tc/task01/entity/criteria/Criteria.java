package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import by.tc.task01.entity.Appliance;

public class Criteria<E> {
	
	private String applianceType;

	private Map<E, Object> criteria = new HashMap<E, Object>();
	private Map<String, Integer> compareCondition = new HashMap<String, Integer>();
	private static Map<String, CriteriaValueType> criteriaValueType=new HashMap();

	public static final int MORE=-1;
	public static final int LESS=1;
	public static final int EQUALS=0;
	
	static {
		criteriaValueType.put("class java.lang.Integer", CriteriaValueType.INTEGER);
		criteriaValueType.put("class java.lang.String", CriteriaValueType.STRING);
		criteriaValueType.put("class java.lang.Float", CriteriaValueType.FLOAT);
		criteriaValueType.put("class java.lang.Double", CriteriaValueType.DOUBLE);
	}
	
	private static enum CriteriaValueType{
		INTEGER, STRING, FLOAT, DOUBLE
	}
	
	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}
	
	public void add(E searchCriteria, Object value, int compareCondition) {
		criteria.put(searchCriteria, value);
		addCompareCondition(searchCriteria, compareCondition);
	}

	public String getApplianceType() {
		return applianceType;
	}

	public void setApplianceType(String applianceType) {
		this.applianceType = applianceType;
	}
		
	public void addCompareCondition(E criteria, int compareConditionValue){
		compareCondition.put(criteria.toString(), compareConditionValue);
	}
	
	public int getCompareCondition(E criteria){
		Integer result=compareCondition.get(criteria.toString());
		if (result==null)
			return 0;
		return result;
	}
	
	public boolean checkApplianceCriteria(Map<String, String> properties) {
		if (!properties.get("applianceType").equals(applianceType))
			return false;
		Set<Entry<E, Object>> criteriaSet=criteria.entrySet();
		//iteration through all criterias
		for (Entry<E, Object> criteriaEntry:criteriaSet) {
			E criteriaKey=(E)criteriaEntry.getKey();
			String criteriaName=criteriaKey.toString();
			int compareCondition=getCompareCondition(criteriaKey);
			Object criteriaValue=criteriaEntry.getValue();
			//checking value of appliance property associated with current criteria by criteriaName
			if (!checkCriteria (criteriaValue, compareCondition, properties.get(criteriaName)))
				return false;
		}
		
		return true;
	}
	//cast appliance property value to criteria value, comparing and condition checking ( > < = ) 
	private boolean checkCriteria(Object criteriaValue, int compareCondition, String applianceFieldValue) {
		CriteriaValueType valueType=getCriteriaValueType(criteriaValue);
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
	
	private static CriteriaValueType getCriteriaValueType(Object criteriaValue){
		String className=criteriaValue.getClass().toString();
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
