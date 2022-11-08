package com.findyourworker.findyourworker.service.Impl;

import com.findyourworker.findyourworker.dto.ComplaintDTO;
import com.findyourworker.findyourworker.entity.Complaint;
import com.findyourworker.findyourworker.repository.ComplaintRepository;
import com.findyourworker.findyourworker.service.ComplaintService;
import com.findyourworker.findyourworker.service.SequenceGeneratorService;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Override
    public void createComplaint(ComplaintDTO complaintDTO) {
        Complaint complaint = modelMapper.map(complaintDTO, Complaint.class);
        complaint.setComplaintId(sequenceGenerator.generateSequence(Complaint.SEQUENCE_NAME));
        complaintRepository.save(complaint);
    }

    @Override
    public void deleteComplaint(String id) {
        complaintRepository.deleteById(id);
    }

    @Override
    public void deleteComplaintByComplaintId(Long complaintId) {
        complaintRepository.deleteByComplaintId(complaintId);
    }

    @Override
    public ComplaintDTO getComplaint(String id) {
         Optional<Complaint> complaint = complaintRepository.findById(id);
        return complaint.map(value -> modelMapper.map(value, ComplaintDTO.class)).orElse(null);
    }

    @Override
    public ComplaintDTO getComplaintByComplaintId(Long complaintId) {
        Optional<Complaint> complaint = complaintRepository.findByComplaintId(complaintId);
        return complaint.map(value -> modelMapper.map(value, ComplaintDTO.class)).orElse(null);
    }

    @Override
    public void updateComplaint(String id, ComplaintDTO complaintDTO) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Complaint complaint = complaintRepository.findById(id).orElse(null);
        if (complaint == null){
            return;
        }
        modelMapper.map(complaintDTO,complaint);
        complaintRepository.save(complaint);

    }

    @Override
    public void updateComplaintByComplaintId(Long complaintId, ComplaintDTO complaintDTO) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Complaint complaint = complaintRepository.findByComplaintId(complaintId).orElse(null);
        if (complaint == null){
            return;
        }
        modelMapper.map(complaintDTO,complaint);
        complaintRepository.save(complaint);
    }

    @Override
    public List<ComplaintDTO> getComplaintList() {
        return modelMapper.map(complaintRepository.findAll(), new TypeToken<List<ComplaintDTO>>(){}.getType());
    }

    @Override
    public List<ComplaintDTO> getComplaintListByEmployeeId(String employeeId) {
        return modelMapper.map(complaintRepository.findAllByEmployeeId(employeeId), new TypeToken<List<ComplaintDTO>>(){}.getType());
    }

    @Override
    public List<ComplaintDTO> getComplaintListByJobId(String jobId) {
        return modelMapper.map(complaintRepository.findAllByJobId(jobId), new TypeToken<List<ComplaintDTO>>(){}.getType());
    }
}
