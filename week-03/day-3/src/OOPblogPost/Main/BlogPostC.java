package OOPblogPost.Main;

public class BlogPostC {
    private String authorName;
    private String title;
    private String text;
    private String publicationDate;

    public BlogPostC(String authorName, String title, String text, String publicationDate) {
        this.authorName = authorName;
        this.title = title;
        this.text = text;
        this.publicationDate = publicationDate;

    }

    public BlogPostC() {

    }

    public void setAuthorName(String auNa) {
        authorName = auNa;
    }

    public String getAuthorName() {
        return authorName + " posted at ";
    }

    public String toString() {
        return title + " titled by " + authorName + " posted at " + publicationDate + text;
    }

    public void setTitle(String titl) {
        title = titl;
    }

    public String getTitle() {
        return title + " titled by ";
    }

    public void setText(String txt) {
        text = txt;
    }

    public String getText() {
        return text;
    }

    public void setDate(String date) {
        publicationDate = date;
    }

    public String getDate() {
        return publicationDate;
    }
}
