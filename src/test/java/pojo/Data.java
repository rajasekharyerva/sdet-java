package pojo;

public class Data {
    private String color;

    // Notice that the variable name has been adapted to Java naming conventions
    private int capacityGB;

    // Getters and Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacityGB() {
        return capacityGB;
    }

    public void setCapacityGB(int capacityGB) {
        this.capacityGB = capacityGB;
    }

    // toString method for easy debugging
    @Override
    public String toString() {
        return "Data{" +
                "color='" + color + '\'' +
                ", capacityGB=" + capacityGB +
                '}';
    }
}

