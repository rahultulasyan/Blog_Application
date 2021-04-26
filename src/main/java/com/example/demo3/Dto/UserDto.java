package com.example.demo3.Dto;

import com.example.demo3.Entity.Blog;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private String name;
    List<Blog> list_blogs = new ArrayList<>();
}
