package gardenapplications;

public class ThePlants {
    private String color;
    private String type;
    private float waterAmount;

    public ThePlants(String color, String type, int waterAmount) {
        this.color = color;
        this.type = type;
        this.waterAmount = waterAmount;
    }

    public boolean needWater() {
        if (type.equals("Flower"))
            return waterAmount < 5;
        return waterAmount < 10;
    }

    public void watering(int water) {
        if (type.equals("Flower"))
            waterAmount += (water * 0.75);
        waterAmount += (water * 0.4);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(float waterAmount) {
        this.waterAmount = waterAmount;
    }
}