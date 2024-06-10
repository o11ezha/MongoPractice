package com.adminka.practice78.Controllers;


import com.adminka.practice78.Models.User;
import com.adminka.practice78.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserContoller{

    @Autowired
    UserService userService;

    @PreAuthorize("hasAuthority('admin_role')")
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PreAuthorize("hasAnyAuthority('admin_role', 'user_role', 'manager_role')")
    @PostMapping("/users/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PreAuthorize("hasAnyAuthority('admin_role', 'user_role', 'manager_role')")
    @DeleteMapping("/users/delete/{userid}")
    public void removeUser(@PathVariable Integer userid){
        userService.removeUser(userid);
    }
}
