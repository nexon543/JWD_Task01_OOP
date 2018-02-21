package by.tc.task01.entity.factory;

public enum ApplianceType {
	
	OVEN, LAPTOP, REFREGERATOR, VACUUME_CLEANER, TABLET_PC, SPEAKERS;
	
	public static ApplianceType getApplianceType(String name){// использование стандартного valueOf для возможности расширения этого перечисления выглядит 
		// более уместным, по крайне мере в метод не надо будет вмешиваться
		switch (name){
		case "VacuumeCleaner": return VACUUME_CLEANER;
		case "TABLET_PC": return TABLET_PC;
		default: return ApplianceType.valueOf(name.toUpperCase());
	}
	}
}
