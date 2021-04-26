package com.example.demo3.Controller;

import com.example.demo3.Dto.UserDto;
import com.example.demo3.Entity.User;
import com.example.demo3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class userController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/user/all")
    public List<User> getUserAll() {
        List<User> users = userService.getUserAll();
        return users;
    }

    @GetMapping(path = "/user/{userId}")
    public UserDto getUser(@PathVariable Long userId) {

        UserDto userDto = userService.getUser(userId);
        return userDto;
    }

    @PostMapping("/user")
    private String saveUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @DeleteMapping("/user/{userId}")
    private String deleteUser(@PathVariable Long userId)
    {
        return userService.deleteUser(userId);
    }


}
