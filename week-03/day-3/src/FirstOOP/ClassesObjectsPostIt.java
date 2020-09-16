package FirstOOP;

public class ClassesObjectsPostIt {

    public static void main(String[] args) {
        PostIt post1 = new PostIt("orange", "Idea 1", "blue");
        PostIt post2 = new PostIt();
        post2.setText("Awesome");
        post2.setBackgroundColor("pink");
        post2.setTextColor("black");

        PostIt post3 = new PostIt("yellow", "Superb!", "green");

        System.out.println(post1.toString());

        System.out.println(post2.getBackgroundColor());
        System.out.println(post2.getTextColor());
        System.out.println(post2.getText());

        System.out.println(post3.toOneLine());


    }
}
/*
    Create a PostIt class that has
        a backgroundColor represented by a String
        a text on it
        a textColor represented by a String
        Create a few example post-it objects:
        an orange with blue text: "Idea 1"
        a pink with black text: "Awesome"
        a yellow with green text: "Superb!"*/
