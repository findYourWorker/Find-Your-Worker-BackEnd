package com.findyourworker.findyourworker.service;

import com.findyourworker.findyourworker.dto.ComplaintDTO;

import java.util.List;
import java.util.Optional;

public interface ComplaintService {
    void createComplaint(ComplaintDTO labourerDTO);

    void deleteComplaint(String id);
    void deleteComplaintByComplaintId(Long labourerId);

    Optional<ComplaintDTO> getComplaint(String id);
    ComplaintDTO getComplaintByComplaintId(Long labourerId);

    void updateComplaint(String id, ComplaintDTO labourerDTO);
    void updateComplaintByComplaintId(Long labourerId, ComplaintDTO labourerDTO);

    List<ComplaintDTO> getComplaintList();

    List<ComplaintDTO> getComplaintListByEmployeeId(Long employeeId);
    List<ComplaintDTO> getComplaintListByJobId(Long jobId);
}
