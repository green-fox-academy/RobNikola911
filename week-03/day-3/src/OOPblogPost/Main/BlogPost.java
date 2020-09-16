package OOPblogPost.Main;

public class BlogPost {
    public static void main(String[] args) {
        BlogPostC postObj1 = new BlogPostC("John Doe", "\"Lorem Ipsum\"",
                "Lorem ipsum dolor sit amet.", "\"2000.05.04.\"" + "\n" + "\t");
        BlogPostC postObj2 = new BlogPostC();
        postObj2.setTitle("\"Wait but why\"");
        postObj2.setAuthorName("Tim Urban");
        postObj2.setDate("\"2010.10.10.\"" + "\n" + "\t");
        postObj2.setText("A popular long-form, stick-figure-illustrated blog about almost everything.");

        System.out.println(postObj1.toString());

        System.out.print(postObj2.getTitle());
        System.out.print(postObj2.getAuthorName());
        System.out.print(postObj2.getDate());
        System.out.print(postObj2.getText());

    }
}


