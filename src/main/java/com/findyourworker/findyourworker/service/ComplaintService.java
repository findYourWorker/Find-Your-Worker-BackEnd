package com.findyourworker.findyourworker.service;

import com.findyourworker.findyourworker.dto.ComplaintDTO;

import java.util.List;

public interface ComplaintService {
    void createComplaint(ComplaintDTO labourerDTO);

    void deleteComplaint(String id);
    void deleteComplaintByComplaintId(Long labourerId);

    ComplaintDTO getComplaint(String id);
    ComplaintDTO getComplaintByComplaintId(Long labourerId);

    void updateComplaint(String id, ComplaintDTO labourerDTO);
    void updateComplaintByComplaintId(Long labourerId, ComplaintDTO labourerDTO);

    List<ComplaintDTO> getComplaintList();

    List<ComplaintDTO> getComplaintListByEmployeeId(String employeeId);
    List<ComplaintDTO> getComplaintListByJobId(String jobId);
}
