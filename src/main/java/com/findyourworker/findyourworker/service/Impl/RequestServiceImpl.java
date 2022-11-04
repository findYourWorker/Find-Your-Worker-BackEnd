package com.findyourworker.findyourworker.service.Impl;


import com.findyourworker.findyourworker.dto.RequestDTO;
import com.findyourworker.findyourworker.entity.Request;
import com.findyourworker.findyourworker.repository.RequestRepository;
import com.findyourworker.findyourworker.service.RequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public RequestDTO createRequest(RequestDTO requestDTO){
        requestRepository.insert(modelMapper.map(requestDTO, Request.class));
        return requestDTO;

    }
    @Override
    public List<RequestDTO> getAllRequests(){
        List<Request>requestList=requestRepository.findAll();
        return modelMapper.map(requestList,new TypeToken<List<RequestDTO>>(){}.getType());
    }
    @Override
    public RequestDTO updateRequest(String id,RequestDTO requestDTO){
        requestRepository.save(modelMapper.map(requestDTO,Request.class));
        return requestDTO;
    }
    @Override
    public boolean deleteUser(String id){
        requestRepository.deleteById(id);
        return true;
    }
}
