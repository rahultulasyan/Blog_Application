package com.example.demo3.Dto;

import com.example.demo3.Entity.Comment;
import com.example.demo3.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class BlogDto {

    private String description;
    List<Comment> list_comm = new ArrayList<>();
}
