package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import by.tc.task01.entity.Appliance;

public class Criteria<E> {
	
	private String applianceType;

	private Map<E, Object> criteria = new HashMap<E, Object>();
	private Map<E, Integer> compareCondition = new HashMap<E, Integer>();
	private static Map<String, CriteriaValueType> criteriaValueType=new HashMap();

	public final int MORE=-1;
	public final int LESS=1;
	public final int EQUALS=0;
	
	static {
		criteriaValueType.put("java.lang.Integer", CriteriaValueType.INTEGER);
		criteriaValueType.put("java.lang.String", CriteriaValueType.STRING);
		criteriaValueType.put("java.lang.Float", CriteriaValueType.FLOAT);
		criteriaValueType.put("java.lang.Double", CriteriaValueType.DOUBLE);
	}
	
	private static enum CriteriaValueType{
		INTEGER, STRING, FLOAT, DOUBLE
	}
	
	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	public String getApplianceType() {
		return applianceType;
	}

	public void setApplianceType(String applianceType) {
		this.applianceType = applianceType;
	}
		
	public void addCompareCondition(E criteria, int compareCondiotionValue){
		compareCondition.put(criteria, compareCondiotionValue);
	}
	
	public int getCompareCondition(E criteria){
		Integer result=compareCondition.get(criteria);
		if (result==null)
			return 0;
		return result;
	}
	
	// зачем эти методы разместил в этом классе?
	// класс же сразу стал тяжелым, и даже просматривать его не очень приятно
	
	// плюс идея проверять, подходит ли тебе инфа, прочитанна из файла для создания объекта, создав уже объект, а потом проверяя параметры - слишком тяжелая
	// Java обладает прекрасными методами поика инфа сразу в строке
	public boolean checkApplianceCriteria(Map<String, String> properties) {
		if (!properties.get("applianceType").equals(applianceType))
			return false;
		Set<Entry<E, Object>> criteriaSet=criteria.entrySet();
		for (Entry<E, Object> criteriaEntry:criteriaSet) {
			E criteriaKey=(E)criteriaEntry.getKey();
			String criteriaName=criteriaKey.toString();
			int compareCondition=getCompareCondition(criteriaKey);
			Object criteriaValue=criteriaEntry.getValue();
			if (!checkCriteria (criteriaValue, compareCondition, properties.get(criteriaName)))
				return false;
		}
		
		return true;
	}

	private boolean checkCriteria(Object criteriaValue, int compareCondition, String applianceFieldValue) {
		CriteriaValueType valueType=getCriteriaValueType(applianceFieldValue);
		switch (valueType){
		
		case INTEGER:
			int applianceIntFieldValue=Integer.parseInt(applianceFieldValue);
			return checkInt((Integer)criteriaValue, compareCondition, applianceIntFieldValue);
		case FLOAT:
			float applianceFloatFieldValue=Float.parseFloat(applianceFieldValue);
			return checkFloat((Float)criteriaValue, compareCondition, applianceFloatFieldValue);
		case STRING: 
			return checkString((String)criteriaValue, applianceFieldValue);
		default://TODO: add Logger
		}
		System.out.println("Checking criteria "+criteriaValue.getClass().toString());
		return true;
	}
	
	private static CriteriaValueType getCriteriaValueType(String applianceFieldValue){
		String className=applianceFieldValue.getClass().toString();
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
