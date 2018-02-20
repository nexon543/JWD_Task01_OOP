package by.tc.task01.entity.criteria;

public enum ApplianceType {
	SPEAKERS,TABLETPC, REFRIGERATOR, LAPTOP, OVEN, VACUUMECLEANER;
	
	public static ApplianceType getApplianceType(String applianceTypeName){
		return ApplianceType.valueOf(applianceTypeName.toUpperCase());
	}
}
