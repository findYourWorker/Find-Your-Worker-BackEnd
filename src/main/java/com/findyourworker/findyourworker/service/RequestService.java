package com.findyourworker.findyourworker.service;

import com.findyourworker.findyourworker.dto.RequestDTO;

import java.util.List;

public interface RequestService {
    RequestDTO createRequest(RequestDTO requestDTO);
    List<RequestDTO> getAllRequests();
    RequestDTO updateRequest(String id,RequestDTO requestDTO);
    boolean deleteUser(String id);
}
