package com.findyourworker.findyourworker.service;

import com.findyourworker.findyourworker.dto.LabourerDTO;
import com.findyourworker.findyourworker.entity.Labourer;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LabourerService {
    void createLabourer(LabourerDTO labourerDTO);

    void deleteLabourer(String id);
    void deleteLabourerByLabourerId(Long labourerId);

    Optional<LabourerDTO> getLabourer(String id);
    LabourerDTO getLabourerByLabourerId(Long labourerId);

    void updateLabourer(String id, LabourerDTO labourerDTO);
    void updateLabourerByLabourerId(Long labourerId, LabourerDTO labourerDTO);

    List<LabourerDTO> getLabourerList();
    List<LabourerDTO> getLabourerListForAdmin(String skip,String take);

    List<LabourerDTO> getLabourerListByLocationSkillAndLabourerId(String location, String skill,Long labourerId, Pageable pageable);

    List<LabourerDTO> getLabourerPaginate(Pageable pageable);

    long getAllLabourerCount();

}
