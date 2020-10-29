package com.greenfox.reddit.services;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void submitPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void increment(Long id) {
        Optional<Post> optional = postRepository.findById(id);
        if (optional.isPresent()) {
            Post post = optional.get();
            post.setLikeCounter(post.getLikeCounter()+1);
            postRepository.save(post);
        }
    }

    @Override
    public void decrement(Long id) {
        Optional<Post> optional = postRepository.findById(id);
        if (optional.isPresent()) {
            Post post = optional.get();
            post.setLikeCounter(post.getLikeCounter()-1);
            postRepository.save(post);
        }
    }

    @Override
    public void updateLikeCounter(Long id, int likeChange) {
        Optional<Post> optional = postRepository.findById(id);
        if (optional.isPresent()) {
            Post updatedPost = optional.get();
            updatedPost.setLikeCounter(updatedPost.getLikeCounter() + likeChange);
            postRepository.save(updatedPost);
        }
    }
}
