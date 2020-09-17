package sharpieset;

public class Sharpie {
    private String color;
    private float width;
    private float inkAmount;

    public Sharpie(String color, float width, float inkAmount) {
        this.color = color;
        this.width = width;
        this.inkAmount = inkAmount;
    }

    public Sharpie() {
        inkAmount = 100f;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    public void setWidth(float width) {
        this.width = width;
    }
    public float getWidth() {
        return width;
    }

    public void setInkAmount(float inkAmount){
        this.inkAmount = inkAmount;
    }
    public float getInkAmount() {
        return inkAmount;
    }
    public void use(){
        inkAmount --;
    }


}