package com.findyourworker.findyourworker.service;

import com.findyourworker.findyourworker.dto.LabourerDTO;
import com.findyourworker.findyourworker.entity.Labourer;

import java.util.List;
import java.util.Optional;

public interface LabourerService {
    void createLabourer(LabourerDTO labourerDTO);

    void deleteLabourer(String id);

    Optional<LabourerDTO> getLabourer(String id);

    void updateLabourer(String id, LabourerDTO labourerDTO);

    List<LabourerDTO> getLabourerList();

    List<LabourerDTO> getLabourerListByLocationAndSkill(String location, String skill);
}
