package by.tc.task01.entity;

public class Speakers extends Appliance {
    private int powerConsumption;
    private int numberOfSpeakers;
    private int cordLength;
    private float freaquencyRange;

    public Speakers() {
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    public float getFreaquencyRange() {
        return freaquencyRange;
    }

    public void setFreaquencyRange(float freaquencyRange) {
        this.freaquencyRange = freaquencyRange;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cordLength;
        result = prime * result + Float.floatToIntBits(freaquencyRange);
        result = prime * result + numberOfSpeakers;
        result = prime * result + powerConsumption;
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
        Speakers other = (Speakers) obj;
        if (cordLength != other.cordLength)
            return false;
        if (Float.floatToIntBits(freaquencyRange) != Float.floatToIntBits(other.freaquencyRange))
            return false;
        if (numberOfSpeakers != other.numberOfSpeakers)
            return false;
        if (powerConsumption != other.powerConsumption)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Speakers [powerConsumption=" + powerConsumption + ", numberOfSpeakers=" + numberOfSpeakers
                + ", cordLength=" + cordLength + ", freaquencyRange=" + freaquencyRange + "]";
    }


}
