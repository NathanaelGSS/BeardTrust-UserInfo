package com.beardtrust.webapp.userinfo.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.beardtrust.webapp.userinfo.entity.UserInfoEntity;
import com.beardtrust.webapp.userinfo.repo.UserInfoRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Nathanael <Nathanael.Grier at your.org>
 */
@RequestMapping("/beardtrust/users")
@RestController
public class UserInfoController {

	private UserInfoRepo repo;
        
        @Autowired
    public UserInfoController(UserInfoRepo repo) {
        this.repo = repo;
    }
    
    @PostMapping("/update/{id}")
    public String updateUser(@RequestBody UserInfoEntity u,  @PathVariable String id) {
        
        Optional<UserInfoEntity> ouser = repo.findById(id);
        if (ouser.isPresent()) {
            repo.save(u);
            return "Update complete!";
        } else {
            String r = "ID found: " + u.getUserId();
            return "Entity not found! " + r;
        }
    }
    
    @GetMapping()//admin access
    public List<UserInfoEntity> getAllUserInfos() {
        return repo.findAll();
    }
    
    @GetMapping("/specific/{id}")
    public Optional<UserInfoEntity> getSpecificUserInfos(@PathVariable String account_id) {
        return repo.findById(account_id);
    }
}
