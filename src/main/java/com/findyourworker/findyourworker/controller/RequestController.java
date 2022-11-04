package com.findyourworker.findyourworker.controller;


import com.findyourworker.findyourworker.dto.RequestDTO;
import com.findyourworker.findyourworker.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="api/request")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PostMapping("/")
    public RequestDTO createRequest(@RequestBody RequestDTO requestDTO){
        return requestService.createRequest(requestDTO);

    }
    @GetMapping("/")
    public List<RequestDTO> getRequests(){
        return requestService.getAllRequests();
    }

    @PutMapping("/{id}")
    public RequestDTO updateRequest(@PathVariable String id, @RequestBody RequestDTO requestDTO){
        return requestService.updateRequest(id,requestDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteRequest(@PathVariable String id){
        return requestService.deleteUser(id);
    }
}
