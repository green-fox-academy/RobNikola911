package com.greenfox.reddit.services;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.repositories.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public int validPage(int nextPage) {
        if (nextPage <= 0) {
            return 0;
        } else if (nextPage > ((postRepository.findAll().size() -1) / 10 )) {
            return (postRepository.findAll().size() -1) / 10;
        }
        return nextPage;
    }

    @Override
    public int[] maxPage() {
        int highestPage = ((postRepository.findAll().size() -1) / 10 ) + 1;
        return java.util.stream.IntStream.range(1, highestPage + 1).toArray();
    }

    @Override
    public List<Post> pageablePostByLikeCounter(Integer page) {
        Pageable sortedByLikeCounter = PageRequest.of(page, 10, Sort.by("LikeCounter").descending());
                List<Post> posts = postRepository.findAllByOrderByLikeCounterDesc(sortedByLikeCounter);
        return posts;
    }
}
