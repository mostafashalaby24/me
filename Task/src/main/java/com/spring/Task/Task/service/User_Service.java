package com.spring.Task.Task.service;

import com.spring.Task.Task.Dao.User_Repositary;
import com.spring.Task.Task.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class User_Service {

    private User_Repositary User_Repositary ;

    @Autowired
    public User_Service(User_Repositary  User_Repositary ) {
        this.User_Repositary  = User_Repositary ;
    }



    public List<User> getUsers()
    {
        return User_Repositary.findAll();
    }

    public User getUserById (Long id){
        return User_Repositary.findById(id).get();
    }
    public User saveUser(User user){
        return User_Repositary.save(user);
    }

    public User editUser(User user){
        return User_Repositary.save(user);
    }

    public void removeUser(@RequestParam Long id){
        User_Repositary.deleteById(id);
    }

}
