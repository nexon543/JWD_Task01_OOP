package by.tc.task01.entity;

public class Oven extends Appliance {
    private int powerConsumption;
    private int weight;
    private int depth;
    private int capacity;
    private float height;
    private float width;

    public Oven() {
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Oven [powerConsumption=" + powerConsumption + ", weight=" + weight + ", depth=" + depth + ", capacity="
                + capacity + ", height=" + height + ", width=" + width + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + capacity;
        result = prime * result + depth;
        result = prime * result + Float.floatToIntBits(height);
        result = prime * result + powerConsumption;
        result = prime * result + weight;
        result = prime * result + Float.floatToIntBits(width);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oven oven = (Oven) o;
        return powerConsumption == oven.powerConsumption &&
                weight == oven.weight &&
                depth == oven.depth &&
                capacity == oven.capacity &&
                Float.compare(oven.height, height) == 0 &&
                Float.compare(oven.width, width) == 0;
    }


}
