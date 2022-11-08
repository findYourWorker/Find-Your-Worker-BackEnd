package com.findyourworker.findyourworker.repository;

import com.findyourworker.findyourworker.entity.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ComplaintRepository extends MongoRepository<Complaint,String> {
    List<Complaint> findAllByEmployeeId(String employeeId);
    List<Complaint> findAllByJobId(String jobId);

    void deleteByComplaintId(Long complaintId);

    Optional<Complaint> findByComplaintId(Long complaintId);
}

