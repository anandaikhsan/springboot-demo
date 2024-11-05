package com.anandaikhsan.demo.processor;

import com.anandaikhsan.demo.service.PostService;
import org.springframework.stereotype.Component;

@Component
public class ProcessorFactory {

    private PostService postService;

    public ProcessorFactory(PostService postService) {
        this.postService = postService;
    }

    public Processor getProcessor(){
        return new ProcessorImpl(postService);
    }
}
