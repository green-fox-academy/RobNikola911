package com.greenfox.reddit.services;

import com.greenfox.reddit.models.Post;
import com.greenfox.reddit.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    PostRepository postRepository;

    public Integer pageNumber = 1;

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
    public List<Post> findAllByOrderByLikeCounterDesc() {
        return postRepository.findAllByOrderByLikeCounterDesc();
    }

    @Override
    public List<Post> findBestTenPost() {
        if (postRepository.count() <= 10) {
            return postRepository.findAllByOrderByLikeCounterDesc();
        }
        return postRepository.findAllByOrderByLikeCounterDesc().subList(0,9);
    }

    @Override
    public Integer pageCounter(Integer numberOfPage) {
        Integer page = postRepository.findAllByOrderByLikeCounterDesc().size();
        if (numberOfPage == 2) {
            if (page < 20) {
                return page;
            }else return 20;
        }
        if (numberOfPage == 3) {
            if (page < 30) {
                return page;
            }else return 30;
        }
        if (numberOfPage == 4) {
            if (page < 40) {
                return page;
            }else return 40;
        }
        return 40;
    }

    @Override
    public List<Post> findTenPostByPage(Integer numberOfPage) {
        return postRepository.findAllByOrderByLikeCounterDesc().subList(((numberOfPage*10)-10), pageCounter(numberOfPage));
    }

    @Override
    public List<Post> showThisPage(Integer numberOfPage) throws Exception {
        if (numberOfPage == null) {
            throw new Exception("No such a page.");
        }else if (numberOfPage == -1) {
            pageNumber--;
        }else if (numberOfPage == 0) {
            pageNumber++;
        }else {
            pageNumber = numberOfPage;
        }
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        if (pageNumber == 1) {
            return findBestTenPost();
        }
        if (pageNumber <= 4) {
            return findTenPostByPage(pageNumber);
        }else {
            throw new Exception("No such a page.");
        }
    }
}
