package com.junittestboot.Junittestboot.controller;

import com.junittestboot.Junittestboot.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("getUserName")
    public String getUserNameS(){
        return "dibya";
    }

    @GetMapping
    public ResponseEntity<User> getUserName(){
        User user = new User();
        user.setPhone(1234);
        user.setUsername("dibya");
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok(user);
    }
}
