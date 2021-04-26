package com.example.demo3.Controller;

import com.example.demo3.Entity.Category;
import com.example.demo3.Entity.Comment;
import com.example.demo3.Entity.User;
import com.example.demo3.Service.CategoryService;
import com.example.demo3.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class categoriesController {
    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "/category/all")
    public List<Category> getCommentsAll() {
        List<Category> categories = categoryService.getCategoryAll();
        return categories;
    }

    @GetMapping(path = "/category/{categoryId}")
    public Category getComment(@PathVariable Long categoryId) {

        Category category = categoryService.getCategory(categoryId);
        return category;
    }

    @PostMapping("/category")
    private String saveBook(@RequestBody Category category)
    {
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/category/{categoryId}")
    private String deleteUser(@PathVariable Long categoryId)
    {
        return categoryService.deleteCategory(categoryId);
    }
}
