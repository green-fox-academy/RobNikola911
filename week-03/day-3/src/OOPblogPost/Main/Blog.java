package OOPblogPost.Main;

//  Create a Blog class which can
//    store a list of BlogPosts
//    add BlogPosts to the list
//    delete(int) one item at given index
//    update(int, BlogPost) one item at the given index and update it with another BlogPost

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Blog {
    private List<BlogPost> listOfBlogPost = new ArrayList<>();

    public Blog() {
    }

    public Blog(List listAdd) {
        listOfBlogPost = listAdd;
    }

    public void delete(int wantedToDelete) {
        try {
            listOfBlogPost.remove(wantedToDelete);
        }catch (IndexOutOfBoundsException ex) {
            System.out.println("That index is not available.");
        }
//    if (wantedToDelete < listOfBlogPost.size()) {
//      listOfBlogPost.remove(wantedToDelete);
//    }
    }

    public void update(int updateIndex,BlogPost newBlogPost) {
        try {
            listOfBlogPost.add(updateIndex,newBlogPost);
        }catch (IndexOutOfBoundsException ex) {
            System.out.println("That index is not available.");
        }
    }
}