package com.anandaikhsan.demo.processor;

import com.anandaikhsan.demo.exception.InvalidPaginationException;
import com.anandaikhsan.demo.model.Post;
import com.anandaikhsan.demo.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class ProcessorImpl implements Processor{

    private PostService service;

    public ProcessorImpl(PostService postService) {
        this.service = postService;
    }

    @Override
    public List<Post> retrieveData() {
        try {
            return service.getPosts();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Post> processList(List<Post> posts, int page, int pageSize) {
        int startingIndex = (page-1) * pageSize;
        if(startingIndex > posts.size()){
            throw new InvalidPaginationException("Invalid pagination");
        }
        return posts.subList(startingIndex, startingIndex + pageSize);
    }
}
