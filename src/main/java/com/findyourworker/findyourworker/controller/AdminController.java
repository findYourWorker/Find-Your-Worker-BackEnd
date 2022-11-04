package com.findyourworker.findyourworker.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1/user")
@CrossOrigin
public class AdminController {

    @GetMapping("/getUser")
    public String getUser(){
        return "Simple-Root";
    }
    @PutMapping("/updateUser")
    public String updateUser(){
        return "user updated!";
    }
    @PostMapping("/saveUser")
    public String saveUser(){
        return "User saved";
    }
    @DeleteMapping("/deleteUser")
    public String deleteUser(){
        return "User saved";
    }



}
