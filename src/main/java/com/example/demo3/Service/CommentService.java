package com.example.demo3.Service;

import com.example.demo3.Dto.CommentInDto;
import com.example.demo3.Dto.UserDto;
import com.example.demo3.Entity.Blog;
import com.example.demo3.Entity.Comment;
import com.example.demo3.Entity.User;
import com.example.demo3.Repo.CommRepo;
import com.example.demo3.Repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommRepo commRepo;

    public List<Comment> getCommentAll() {
        return commRepo.findAll();
    }


    public Comment getComment(Long commId) {
        Comment comment = commRepo.findById(commId).get();
        return comment;
    }

    public List<Comment> getUserComments(Long userId) {
        return commRepo.getCommentsUser(userId);
    }

    public List<Comment> getBlogComments(Long blogId) {
        return commRepo.getCommentsBlog(blogId);
    }


    public String addcomment(CommentInDto commentInDto) {
        Comment comment = new Comment();
        try {
            if(!commRepo.existsById(commentInDto.getComm_id())) {
                BeanUtils.copyProperties(commentInDto, comment);
                User user = new User();
                user.setUser_id(commentInDto.getUser_id());
                comment.setUser(user);
                Blog blog = new Blog();
                blog.setBlog_id(commentInDto.getBlog_id());
                comment.setBlog(blog);

                commRepo.save(comment);
            }
            else {
                return "Comment Already Exists";
            }
        }
        catch(Exception e) {
            return "Error while adding";
        }
        return "success";
    }

    public String deleteComment(Long commId) {

        try {
            commRepo.deleteById(commId);
        }
        catch(Exception e) {
            return "Error while deleting";
        }
        return "success";
    }

}
