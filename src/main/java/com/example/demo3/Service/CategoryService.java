package com.example.demo3.Service;

import com.example.demo3.Dto.UserDto;
import com.example.demo3.Entity.Category;
import com.example.demo3.Entity.User;
import com.example.demo3.Repo.CategoryRepo;
import com.example.demo3.Repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public Category getCategory(Long categoryID) {
        return categoryRepo.getOne(categoryID);
    }
    public List<Category> getCategoryAll() {
        return categoryRepo.findAll();
    }


    public String addCategory(Category category) {
        try {
            if(!categoryRepo.existsById(category.getCat_id())) {
                categoryRepo.save(category);
            }
            else {
                return "Category Already Exists";
            }
        }
        catch(Exception e) {
            return "Error while adding";
        }
        return "success";
    }

    public String deleteCategory(Long categoryID) {

        try {
            categoryRepo.deleteById(categoryID);
        }
        catch(Exception e) {
            return "Error while deleting";
        }
        return "success";
    }

}
