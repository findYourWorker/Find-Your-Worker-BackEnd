package com.findyourworker.findyourworker.service.Impl;

import com.findyourworker.findyourworker.dto.ComplaintDTO;
import com.findyourworker.findyourworker.service.ComplaintService;

import java.util.List;
import java.util.Optional;

public class ComplaintServiceImpl implements ComplaintService {

    @Override
    public void createComplaint(ComplaintDTO labourerDTO) {

    }

    @Override
    public void deleteComplaint(String id) {

    }

    @Override
    public void deleteComplaintByComplaintId(Long labourerId) {

    }

    @Override
    public Optional<ComplaintDTO> getComplaint(String id) {
        return Optional.empty();
    }

    @Override
    public ComplaintDTO getComplaintByComplaintId(Long labourerId) {
        return null;
    }

    @Override
    public void updateComplaint(String id, ComplaintDTO labourerDTO) {

    }

    @Override
    public void updateComplaintByComplaintId(Long labourerId, ComplaintDTO labourerDTO) {

    }

    @Override
    public List<ComplaintDTO> getComplaintList() {
        return null;
    }

    @Override
    public List<ComplaintDTO> getComplaintListByEmployeeId(Long employeeId) {
        return null;
    }

    @Override
    public List<ComplaintDTO> getComplaintListByJobId(Long jobId) {
        return null;
    }
}
