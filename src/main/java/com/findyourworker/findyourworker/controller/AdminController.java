package com.findyourworker.findyourworker.controller;

import com.findyourworker.findyourworker.dto.AdminDTO;
import com.findyourworker.findyourworker.dto.LabourerDTO;
import com.findyourworker.findyourworker.entity.Labourer;
import com.findyourworker.findyourworker.service.AdminService;
import com.findyourworker.findyourworker.service.LabourerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private LabourerService labourerService;

    @Autowired
    private AdminService adminService;
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

    @GetMapping("/all-labourers")
    public List<LabourerDTO> getAllLabourers(@RequestParam("skip") Integer skip){
        System.out.println("skipping"+skip);
        return labourerService.getLabourerList();

    }

    @PostMapping("/createAdmin")
    public void saveUser(@RequestBody AdminDTO adminDTO){
//        System.out.println(adminDTO.getUsername());
//        System.out.println(adminDTO.getPassword());
        adminService.saveAdmin(adminDTO);
    }


}
