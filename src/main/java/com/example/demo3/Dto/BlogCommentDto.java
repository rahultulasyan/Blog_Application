package com.example.demo3.Dto;

import lombok.Data;

@Data
public class BlogCommentDto {
    private Long blog_id;
    private Long user_id;
    private Long comm_id;
}
