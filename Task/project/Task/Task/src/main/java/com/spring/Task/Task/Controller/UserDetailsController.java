package com.spring.Task.Task.Controller;


import com.spring.Task.Task.model.User;
import com.spring.Task.Task.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// http://localhost:4200
@RequestMapping("api/")
public class UserDetailsController {

    private User_Service User_Service;

    @Autowired
    public UserDetailsController(User_Service UserService) {
        this.User_Service = UserService;
    }



    // http://localhost:8080/api/users
    @GetMapping("users")
    public List<User> getUsers()
    {
        return User_Service.getUsers();
    }

    // http://localhost:8080/api/user?id=12
    @GetMapping("user")
    public User getUserById (@RequestParam Long id){
        return User_Service.getUserById(id);
    }

    // http://localhost:8080/api/users
    @PostMapping("users")
    public User saveUser(@RequestBody User user){
        return User_Service.saveUser(user);
    }

    // http://localhost:8080/api/user?id=12
    @PutMapping("user")
    public User editUser(@RequestBody User user,@RequestParam Long id){
        user.setId(id);
        return User_Service.saveUser(user);
    }
    @DeleteMapping("user")
    public void removeUser(@RequestParam Long id){
        User_Service.removeUser(id);
    }



}
