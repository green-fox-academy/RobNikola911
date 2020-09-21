package OOPblogPost.Main;

import java.util.ArrayList;
import java.util.List;

public class BlogPost {
    public static void main(String[] args) {
        String[] name = {
                    "John Doe",
                    "Tim Urban",
                    "William Turton"
            };
            String[] title = {
                    "Lorem Ipsum",
                    "Wait but why",
                    "One Engineer Is Trying to Get IBM to Reckon With Trump"
            };
            String[] text = {
                    "Lorem ipsum dolor sit amet.",
                    "A popular long-form, stick-figure-illustrated blog about almost everything.",
                    "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center" +
                            " of attention. When I asked to take his picture outside one of IBM’s New York City" +
                            " offices, he told me that he wasn’t really into the whole organizer profile thing.",
            };
            String[] publicationDate = {
                    "2000.05.04.",
                    "2010.10.10.",
                    "2017.03.28."
            };

            List<BlogPost> listOfBlogPosts = new ArrayList<>();
            BlogPost practiceOne = new BlogPost(name[0], title[0], text[0], publicationDate[0]);
            BlogPost practiceTwo = new BlogPost(name[1], title[1], text[1], publicationDate[1]);
            BlogPost practiceThree = new BlogPost(name[2], title[2], text[2], publicationDate[2]);
            listOfBlogPosts.add(practiceOne);
            listOfBlogPosts.add(practiceTwo);
            listOfBlogPosts.add(practiceThree);
            Blog blogOne = new Blog(listOfBlogPosts);
            System.out.println(listOfBlogPosts.size());
            BlogPost practiceFour = new BlogPost(name[1],title[2],text[0],publicationDate[2]);
            blogOne.update(5,practiceFour);
            System.out.println(listOfBlogPosts.size());
            blogOne.delete(5);
            System.out.println(listOfBlogPosts.size());
            for (BlogPost blog :listOfBlogPosts) {
                System.out.println();
            }

        }
    }


