package com.anandaikhsan.demo.service;

import com.anandaikhsan.demo.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostService {
    private static final String url = "https://jsonplaceholder.typicode.com/posts";

    public List<Post> getPosts() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String response =  restTemplate.getForObject(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, new TypeReference<List<Post>>(){});
    }
}
