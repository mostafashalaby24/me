package com.spring.Task.Task.Dao;

import com.spring.Task.Task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repositary extends JpaRepository<User,Long> {

}
