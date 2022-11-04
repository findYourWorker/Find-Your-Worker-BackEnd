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

    @PostMapping("/create-request")
    public RequestDTO createRequest(@RequestBody RequestDTO requestDTO){
        return requestService.createRequest(requestDTO);

    }
    @GetMapping("/get-requests")
    public List<RequestDTO> getRequests(){
        return requestService.getAllRequests();
    }

    @PutMapping("/update-request")
    public RequestDTO updateRequest(@RequestBody RequestDTO requestDTO){
        return requestService.updateRequest(requestDTO);
    }

    @DeleteMapping("/delete-request")
    public boolean deleteRequest(@RequestBody RequestDTO requestDTO){
        return requestService.deleteUser(requestDTO);
    }
}
