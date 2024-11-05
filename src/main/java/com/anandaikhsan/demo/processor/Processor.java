package com.anandaikhsan.demo.processor;

import com.anandaikhsan.demo.model.Post;

import java.util.List;

public interface Processor {
    List<Post> retrieveData();
    List<Post> processList(List<Post> posts, int page, int pageSize);

}
