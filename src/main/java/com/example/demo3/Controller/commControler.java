package com.example.demo3.Controller;

import com.example.demo3.Dto.BlogDto;
import com.example.demo3.Dto.BlogInDto;
import com.example.demo3.Dto.CommentInDto;
import com.example.demo3.Entity.Blog;
import com.example.demo3.Entity.Comment;
import com.example.demo3.Repo.BlogRepo;
import com.example.demo3.Repo.CommRepo;
import com.example.demo3.Service.BlogService;
import com.example.demo3.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class commControler {

    @Autowired
    CommentService commentService;

    @GetMapping(path = "/comment/all")
    public List<Comment> getCommentsAll() {
        List<Comment> comments = commentService.getCommentAll();
        return comments;
    }

    @GetMapping(path = "/comment/{commId}")
    public Comment getComment(@PathVariable Long commId) {

        Comment comment = commentService.getComment(commId);
        return comment;
    }

    @GetMapping(path = "/comment/user/{userId}")
    public List<Comment> getUserComments(@PathVariable Long userId) {

        List<Comment> comments = commentService.getUserComments(userId);
        return comments;
    }

    @GetMapping(path = "/comment/blog/{blogId}")
    public List<Comment> getBlogComments(@PathVariable Long blogId) {

        List<Comment> comments = commentService.getBlogComments(blogId);
        return comments;
    }

    @PostMapping("/comment")
    private String addBlog(@RequestBody CommentInDto commnet)
    {
        return commentService.addcomment(commnet);
    }

    @DeleteMapping("/comment/{commId}")
    private String deleteBlog(@PathVariable Long commId)
    {
        return commentService.deleteComment(commId);
    }

}
