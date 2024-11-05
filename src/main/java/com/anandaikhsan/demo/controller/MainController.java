package com.anandaikhsan.demo.controller;

import com.anandaikhsan.demo.model.Post;
import com.anandaikhsan.demo.processor.Processor;
import com.anandaikhsan.demo.processor.ProcessorFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class MainController {
    private ProcessorFactory processorFactory;

    public MainController(ProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    @GetMapping({"/{page}/{pageSize}", "/"})
    public List<Post> getPosts(@PathVariable("page") String page, @PathVariable("pageSize") String pageSize) throws JsonProcessingException {
        Processor processor = processorFactory.getProcessor();
        List<Post> posts =  processor.retrieveData();
        return processor.processList(posts, Integer.parseInt(page), Integer.parseInt(pageSize));
    }
}
