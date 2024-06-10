package com.adminka.practice78.Controllers;

import com.adminka.practice78.DTO.ItemDTO;
import com.adminka.practice78.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@PreAuthorize("hasAnyAuthority('admin_role', 'user_role', 'manager_role')")
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/items/add")
    public void addOrder(@RequestBody ItemDTO itemDTO, Principal principal){
        itemService.addOrder(itemDTO, principal.getName());
    }
}
