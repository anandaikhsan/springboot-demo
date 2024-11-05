package com.anandaikhsan.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Post {
    private Integer id;
    private String title;
    @JsonIgnore
    private String userId;
    @JsonIgnore
    private String body;
}
