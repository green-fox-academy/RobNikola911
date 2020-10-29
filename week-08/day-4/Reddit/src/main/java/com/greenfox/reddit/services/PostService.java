package com.greenfox.reddit.services;

import com.greenfox.reddit.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllPosts();
    void submitPost(Post post);

    void increment(Long id);
    void decrement(Long id);

    void updateLikeCounter(Long id, int likeChange);
    List<Post> findAllByOrderByLikeCounterDesc();
    List<Post> findBestTenPost();
    List<Post> findTenPostByPage(Integer numberOfPage);
    Integer pageCounter(Integer numberOfPage);
    List<Post> showThisPage(Integer numberOfPage) throws Exception;
}
