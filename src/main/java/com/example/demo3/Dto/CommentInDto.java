package com.example.demo3.Dto;

import lombok.Data;

@Data
public class CommentInDto {
    private Long comm_id;
    private String description;
    private Long user_id;
    private Long blog_id;
}
