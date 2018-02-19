package by.tc.task01.entity.factory;

public enum ApplianceType {
	
	OVEN, LAPTOP, REFREGERATOR, VACUUME_CLEANER, TABLET_PC, SPEAKERS;
	
	public static ApplianceType getApplianceType(String name){
		switch (name){
		case "VacuumeCleaner": return VACUUME_CLEANER;
		case "TABLET_PC": return TABLET_PC;
		default: return ApplianceType.valueOf(name.toUpperCase());
	}
	}
}
