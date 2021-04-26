package com.example.demo3.Controller;

import com.example.demo3.Dto.BlogCatDto;
import com.example.demo3.Dto.BlogCommentDto;
import com.example.demo3.Dto.BlogDto;
import com.example.demo3.Dto.BlogInDto;
import com.example.demo3.Entity.Blog;
import com.example.demo3.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")
public class blogController {

    @Autowired
    BlogService blogService;


    @GetMapping(path = "/blog/all")
    public List<Blog> getUserAll() {
        List<Blog> blogs = blogService.getBlogAll();
        return blogs;
    }

    @GetMapping(path = "/blog/user/{userId}")
    public List<Blog> getUserBlogs(@PathVariable Long userId) {

        List<Blog> blogs = blogService.getUsersBlog(userId);
        return blogs;
    }

    @GetMapping(path = "/blog/{blogId}")
    public BlogDto getBlog(@PathVariable Long blogId) {

        BlogDto blogDto = blogService.getBlog(blogId);
        return blogDto;
    }

    @PostMapping("/blog")
    private String addBlog(@RequestBody BlogInDto blog)
    {
        return blogService.addBlog(blog);
    }

    @PostMapping("/blog/addcategory")
    private String addBlogCategory(@RequestBody BlogCatDto blog)
    {
        return blogService.addBlogCategory(blog);
    }

//    @PostMapping("/blog/addComment")
//    private String addBlogCategory(@RequestBody BlogCommentDto blog)
//    {
//        return blogService.addBlogComment(blog);
//    }

    @DeleteMapping("/blog/{blogId}")
    private String deleteBlog(@PathVariable Long blogId)
    {
        return blogService.deleteBlog(blogId);
    }
}

