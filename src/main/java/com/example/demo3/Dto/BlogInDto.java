package com.example.demo3.Dto;

import com.example.demo3.Entity.Comment;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class BlogInDto {

    private Long blog_id;
    private String description;
    private Long user_id;
}



