package com.example.demo3.Repo;

import com.example.demo3.Entity.Blog;
import com.example.demo3.Entity.Category;
import com.example.demo3.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {



}
