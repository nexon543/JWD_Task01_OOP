package by.tc.task01.entity;

public class VacuumCleaner extends Appliance {

    private int powerConsumption;
    private char filterType;
    private int bagType;
    private String wandType;
    private int motorSpeedRegulation;
    private int cleaningWidth;

    public VacuumCleaner() {
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public char getFilterType() {
        return filterType;
    }

    public void setFilterType(char filterType) {
        this.filterType = filterType;
    }

    public int getBagType() {
        return bagType;
    }

    public void setBagType(int bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bagType;
        result = prime * result + cleaningWidth;
        result = prime * result + filterType;
        result = prime * result + motorSpeedRegulation;
        result = prime * result + powerConsumption;
        result = prime * result + ((wandType == null) ? 0 : wandType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VacuumCleaner other = (VacuumCleaner) obj;
        if (bagType != other.bagType)
            return false;
        if (cleaningWidth != other.cleaningWidth)
            return false;
        if (filterType != other.filterType)
            return false;
        if (motorSpeedRegulation != other.motorSpeedRegulation)
            return false;
        if (powerConsumption != other.powerConsumption)
            return false;
        if (wandType == null) {
            if (other.wandType != null)
                return false;
        } else if (!wandType.equals(other.wandType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "VacuumCleaner [powerConsumption=" + powerConsumption + ", filterType=" + filterType + ", bagType="
                + bagType + ", wandType=" + wandType + ", motorSpeedRegulation=" + motorSpeedRegulation
                + ", cleaningWidth=" + cleaningWidth + "]";
    }


}
