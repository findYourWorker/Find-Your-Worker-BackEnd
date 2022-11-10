package com.findyourworker.findyourworker.controller;

import com.findyourworker.findyourworker.dto.AdminDTO;
import com.findyourworker.findyourworker.dto.LabourerDTO;
import com.findyourworker.findyourworker.entity.Labourer;
import com.findyourworker.findyourworker.service.AdminService;
import com.findyourworker.findyourworker.service.LabourerService;
import com.mongodb.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Pattern;

import java.util.List;
import java.util.Map;

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
    public List<LabourerDTO> getAllLabourers(@RequestParam Integer page, @RequestParam Integer size){
//        System.out.println("skipping"+skip);
//        String skip=reqParam.get("skip");
//        String take=reqParam.get("take");
//        String searchBy=reqParam.get("search_by");
//        String filterBy=reqParam.get("filter_by");
//        return labourerService.getLabourerListForAdmin(skip,take);

        return labourerService.getLabourerPaginate(Pageable.ofSize(size).withPage(page));
    }


    @GetMapping("/labourers-count")
    public Long getAllLabourersCount(){
        return labourerService.getAllLabourerCount();
    }
//    @GetMapping("/page")
//    public List<LabourerDTO> labourerListPaginate(){
//        return labourerService.getLabourerPaginate(Pageable.ofSize(size).withPage(page));
//    }

    @PostMapping("/createAdmin")
    public void saveUser(@RequestBody AdminDTO adminDTO){
//        System.out.println(adminDTO.getUsername());
//        System.out.println(adminDTO.getPassword());
        adminService.saveAdmin(adminDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<LabourerDTO>> labourerListByLocation(@RequestParam @Nullable String location, @RequestParam @Nullable String skill,@RequestParam @Nullable Long labourerId,@RequestParam Integer page, @RequestParam Integer size){
        System.out.println("location"+location);
        System.out.println("skill"+skill);
        System.out.println("labourerid"+labourerId);
        List<LabourerDTO> labourerDTOList = labourerService.getLabourerListByLocationSkillAndLabourerId(location,skill,labourerId,Pageable.ofSize(size).withPage(page));
        if (labourerDTOList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(labourerDTOList,HttpStatus.OK);
    }
    @PostMapping("/change-active")
    public void changeActivation(@RequestParam String labourerId){
        System.out.println("labourerid printing"+labourerId);
        adminService.changeActivation(labourerId);
    }
    @PostMapping("/create-labourer")
    public ResponseEntity<HttpStatus> createLabourer(@RequestBody LabourerDTO labourerDTO){
        System.out.println(labourerDTO);
        labourerService.createLabourer(labourerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}
