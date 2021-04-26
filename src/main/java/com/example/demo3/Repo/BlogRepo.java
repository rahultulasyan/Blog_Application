package com.example.demo3.Repo;

import com.example.demo3.Entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepo extends JpaRepository<Blog, Long> {

    @Query(value = "SELECT * FROM BLOG WHERE USER_id=?1", nativeQuery = true)
    public List<Blog> getUserBlogs(Long userId);

//    @Query(value = "INSERT INTO category_blog VALUES ( 2, 1)", nativeQuery = true)
//    void addBlogCategory(Long blog_id, Long cat_id);
}
