package com.findyourworker.findyourworker.service;


import com.findyourworker.findyourworker.dto.RequestDTO;
import com.findyourworker.findyourworker.entity.Request;
import com.findyourworker.findyourworker.repository.RequestRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RequestDTO createRequest(RequestDTO requestDTO){
        requestRepository.insert(modelMapper.map(requestDTO, Request.class));
        return requestDTO;

    }
    public List<RequestDTO> getAllRequests(){
        List<Request>requestList=requestRepository.findAll();
        return modelMapper.map(requestList,new TypeToken<List<RequestDTO>>(){}.getType());
    }

    public RequestDTO updateRequest(RequestDTO requestDTO){
        requestRepository.save(modelMapper.map(requestDTO,Request.class));
        return requestDTO;
    }
    public boolean deleteUser(RequestDTO requestDTO){
        requestRepository.delete(modelMapper.map(requestDTO,Request.class));
        return true;
    }
}
