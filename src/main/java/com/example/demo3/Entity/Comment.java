package com.example.demo3.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    @Id
    private long comm_id;
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    Blog blog;
}
