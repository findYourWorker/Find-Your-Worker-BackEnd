package com.findyourworker.findyourworker.controller;


import com.findyourworker.findyourworker.dto.LabourerDTO;
import com.findyourworker.findyourworker.service.LabourerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void createLabourer(@RequestBody LabourerDTO labourerDTO){
        labourerService.createLabourer(labourerDTO);

    }
    @DeleteMapping("/{id}")
    public void deleteLabourer(@PathVariable String id){
        labourerService.deleteLabourer(id);
    }
    @PutMapping("/{id}")
    public void updateLabourer(@PathVariable String id,@RequestBody LabourerDTO labourerDTO){
        labourerService.updateLabourer(id,labourerDTO);
    }
    @GetMapping("/{id}")
    public LabourerDTO getLabourer(@PathVariable String id){
        Optional<LabourerDTO> labourerDTO = labourerService.getLabourer(id);
        return labourerDTO.orElse(null);
    }

    @GetMapping("/")
    public List<LabourerDTO> labourerList(){
        return labourerService.getLabourerList();
    }

    @GetMapping("/search")
    public List<LabourerDTO> labourerListByLocation(@RequestParam String location, @RequestParam String skill){
        return labourerService.getLabourerListByLocationAndSkill(location,skill);
    }
}
