package com.findyourworker.findyourworker.controller;


import com.findyourworker.findyourworker.dto.LabourerDTO;
import com.findyourworker.findyourworker.service.LabourerService;
import com.mongodb.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value="api/labourer")
public class LabourerController {

    @Autowired
    private LabourerService labourerService;

    @PostMapping("/")
    public ResponseEntity<HttpStatus> createLabourer(@RequestBody LabourerDTO labourerDTO){
        System.out.println(labourerDTO);
        labourerService.createLabourer(labourerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void deleteLabourer(@PathVariable Long id){
        labourerService.deleteLabourerByLabourerId(id);
    }
    @PutMapping("/{id}")
    public void updateLabourer(@PathVariable Long id,@RequestBody LabourerDTO labourerDTO){
        labourerService.updateLabourerByLabourerId(id,labourerDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LabourerDTO> getLabourer(@PathVariable Long id){
        LabourerDTO labourerDTO = labourerService.getLabourerByLabourerId(id);
        if (labourerDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(labourerDTO,HttpStatus.OK);
    }

    @GetMapping("/")
    public List<LabourerDTO> labourerList(){
        return labourerService.getLabourerList();
    }

    //TODO: Pagination kalindu




}
