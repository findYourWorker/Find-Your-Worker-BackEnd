package com.findyourworker.findyourworker.controller;


import com.findyourworker.findyourworker.entity.Labourer;
import com.findyourworker.findyourworker.repository.LabourerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="api/labourer")
public class LabourerController {

    @Autowired
    private LabourerRepository labourerRepository;

    @PostMapping("/create")
    public void createLabourer(@RequestBody Labourer labourer){
        System.out.println(labourer);
        labourerRepository.insert(labourer);

    }
    @PostMapping("/delete/{id}")
    public void deleteLabourer(@PathVariable String id){
        labourerRepository.deleteById(id);

    }
    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable String id){
        return "Simple-Root";
    }

    @GetMapping("/list")
    public List<Labourer> labourerList(){
        return labourerRepository.findAll();
    }

}
