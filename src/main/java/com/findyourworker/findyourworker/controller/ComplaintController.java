package com.findyourworker.findyourworker.controller;

import com.findyourworker.findyourworker.dto.ComplaintDTO;
import com.findyourworker.findyourworker.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="api/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/")
    public ResponseEntity<HttpStatus> createComplaint(@RequestBody ComplaintDTO complaintDTO){
        complaintService.createComplaint(complaintDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id){
        complaintService.deleteComplaintByComplaintId(id);
    }
    @PutMapping("/{id}")
    public void updateComplaint(@PathVariable Long id,@RequestBody ComplaintDTO complaintDTO){
        complaintService.updateComplaintByComplaintId(id,complaintDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ComplaintDTO> getComplaint(@PathVariable Long id){
        ComplaintDTO complaintDTO = complaintService.getComplaintByComplaintId(id);
        if (complaintDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(complaintDTO,HttpStatus.OK);
    }

    @GetMapping("/")
    public List<ComplaintDTO> complaintList(){
        return complaintService.getComplaintList();
    }


}
