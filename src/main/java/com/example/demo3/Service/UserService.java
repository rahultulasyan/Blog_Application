package com.example.demo3.Service;

import com.example.demo3.Dto.UserDto;
import com.example.demo3.Entity.User;
import com.example.demo3.Repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getUserAll() {
        return userRepo.findAll();
    }

    public UserDto getUser(Long userId) {

        UserDto userDto = new UserDto();
        User user = userRepo.getOne(userId);

        BeanUtils.copyProperties(user, userDto);
//        userDto.setName(user.getName());
        return userDto;
    }

    public String addUser(User user) {
        try {
            if(!userRepo.existsById(user.getUser_id())) {
                userRepo.save(user);
            }
            else {
                return "User Already Exists";
            }
        }
        catch(Exception e) {
            return "Error while adding";
        }
        return "success";
    }

    public String deleteUser(Long userID) {

        try {
            userRepo.deleteById(userID);
        }
        catch(Exception e) {
            return "Error while deleting";
        }
        return "success";
    }

}
