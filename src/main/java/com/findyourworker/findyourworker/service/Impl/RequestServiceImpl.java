package com.findyourworker.findyourworker.service.Impl;


import com.findyourworker.findyourworker.dto.RequestDTO;
import com.findyourworker.findyourworker.entity.Request;
import com.findyourworker.findyourworker.repository.RequestRepository;
import com.findyourworker.findyourworker.service.RequestService;
import com.findyourworker.findyourworker.service.SequenceGeneratorService;
import org.modelmapper.Conditions;
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

    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Override
    public RequestDTO createRequest(RequestDTO requestDTO){
        Request request = modelMapper.map(requestDTO, Request.class);
        request.setRequestId(sequenceGenerator.generateSequence(Request.SEQUENCE_NAME));
        requestRepository.save(request);
        return modelMapper.map(request, RequestDTO.class);

    }
    @Override
    public List<RequestDTO> getAllRequests(){
        List<Request>requestList=requestRepository.findAll();
        return modelMapper.map(requestList,new TypeToken<List<RequestDTO>>(){}.getType());
    }
    @Override
    public RequestDTO updateRequest(String id,RequestDTO requestDTO){
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Request request = requestRepository.findById(id).orElse(null);
        if (request == null){
            return null;
        }
        modelMapper.map(requestDTO,request);
        requestRepository.save(request);
        return modelMapper.map(request,RequestDTO.class);
    }
    @Override
    public boolean deleteUser(String id){
        requestRepository.deleteById(id);
        return true;
    }
}
