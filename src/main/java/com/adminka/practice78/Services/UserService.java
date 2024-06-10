package com.adminka.practice78.Services;

import com.adminka.practice78.Models.User;
import com.adminka.practice78.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void addUser(User user){
        String sql = "CALL add_user(?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUserName(), user.getUserPassword(), user.getUserEmail(), user.getUserRole());
    }

    public void removeUser(Integer userid){
        String sql = "CALL del_user(?)";
        jdbcTemplate.update(sql, userid);
    }
}
