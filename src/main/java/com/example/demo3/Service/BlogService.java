package com.example.demo3.Service;

import com.example.demo3.Dto.BlogCatDto;
import com.example.demo3.Dto.BlogCommentDto;
import com.example.demo3.Dto.BlogDto;
import com.example.demo3.Dto.BlogInDto;
import com.example.demo3.Entity.Blog;
import com.example.demo3.Entity.Category;
import com.example.demo3.Entity.Comment;
import com.example.demo3.Entity.User;
import com.example.demo3.Repo.BlogRepo;
import com.example.demo3.Repo.CategoryRepo;
import com.example.demo3.Repo.CommRepo;
import com.example.demo3.Repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepo blogRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CommRepo commRepo;

    public BlogDto getBlog(Long blogId) {

        BlogDto blogDto = new BlogDto();
        Blog blog = blogRepo.getOne(blogId);

        BeanUtils.copyProperties(blog, blogDto);
//        userDto.setName(user.getName());
        return blogDto;
    }

    public String addBlog(BlogInDto blogInDto) {
        Blog blog = new Blog();
        try {
            if(!blogRepo.existsById(blog.getBlog_id())) {
                BeanUtils.copyProperties(blogInDto, blog);
                User user = new User();
                user.setUser_id(blogInDto.getUser_id());
                blog.setUser(user);
                blogRepo.save(blog);
            }
            else {
                return "Blog Already Exists";
            }
        }
        catch(Exception e) {
            System.out.println(e.toString());
            return "Error while adding";
        }
        return "success";
    }

    public String deleteBlog(Long blogId) {

        try {
            blogRepo.deleteById(blogId);
        }
        catch(Exception e) {
            return "Error while deleting";
        }
        return "success";
    }

    public List<Blog> getBlogAll() {
        return blogRepo.findAll();
    }

    public List<Blog> getUsersBlog(Long userId) {
        return blogRepo.getUserBlogs(userId);
    }

    public String addBlogCategory(BlogCatDto blogCatDto) {
        try {

            Blog blog = blogRepo.findById(blogCatDto.getBlog_id()).get();
            Category cat = categoryRepo.findById(blogCatDto.getCat_id()).get();

            //Adding references both side
            blog.getCategoryList().add(cat);
            cat.getBlogList().add(blog);

            blogRepo.save(blog);


//            blogRepo.addBlogCategory(blog.getBlog_id(), blog.getCat_id());
        } catch (Exception e){
            System.out.println(e.toString());
            return "Error";
        }

        return "Success";
    }

//    public String addBlogComment(BlogCommentDto blogCommentDto) {
//
//        System.out.println(blogCommentDto);
//        try {
//            System.out.println(0);
//            Blog blog = blogRepo.findById(blogCommentDto.getBlog_id()).get();
//            System.out.println(1);
//            User user = userRepo.findById(blogCommentDto.getUser_id()).get();
//            System.out.println(2);
//            Comment comm = new Comment(blogCommentDto.getComm_id(), "Frefre", user, blog);
//            blog.getList_comm().add(comm);
//            user.getList_comm().add(comm);
//
//            blogRepo.save(blog);
//
//
//        } catch (Exception e) {
//            System.out.println(e.toString());
//            return "Error";
//        }
////
////        return "success";
//        return "fR";
//    }
}
