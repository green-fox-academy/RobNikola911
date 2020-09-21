package OOPblogPost.Main;

public class BlogPostC {
        private String authorName;
        private String title;
        private String text;
        private String publicationDate;


        public BlogPostC() {
        }

        public BlogPostC(String name,String titleAdd, String textAdd, String publicDate) {
            authorName = name;
            title = titleAdd;
            text = textAdd;
            publicationDate = publicDate;
        }

    }