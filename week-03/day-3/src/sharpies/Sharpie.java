package sharpies;

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

/*
    Create Sharpie class
We should know about each sharpie their color (which should be a string),
width (which will be a floating point number), inkAmount (another floating point number)
        When creating one, we need to specify the color and the width
        Every sharpie is created with a default 100 as inkAmount
        We can use() the sharpie objects
        which decreases inkAmount
        */
