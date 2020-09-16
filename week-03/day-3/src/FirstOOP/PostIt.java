package FirstOOP;

public class PostIt {
    private String backgroundColor;
    private String text;
    private String textColor;

    public PostIt(String backgroundColor, String text, String textColor) {
        this.backgroundColor = backgroundColor;
        this.text = text;
        this.textColor = textColor;
    }

    public PostIt() {

    }

    public void setBackgroundColor(String bgc) {
        backgroundColor = bgc;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }


    public void setText(String textVar) {
        text = textVar;
    }

    public String getText() {
        return text;
    }


    public void setTextColor(String txtc) {
        textColor = txtc;
    }

    public String getTextColor() {
        return textColor;
    }

    public String toString() {
        return backgroundColor + " " + textColor + " " + text;
    }

    public String toOneLine() {
        return backgroundColor + " " + textColor + " " + text;
    }
}

