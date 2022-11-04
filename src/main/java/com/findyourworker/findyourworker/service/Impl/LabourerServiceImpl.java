package com.findyourworker.findyourworker.service.Impl;

import com.findyourworker.findyourworker.dto.LabourerDTO;
import com.findyourworker.findyourworker.entity.Labourer;
import com.findyourworker.findyourworker.repository.LabourerRepository;
import com.findyourworker.findyourworker.service.LabourerService;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabourerServiceImpl implements LabourerService {

    @Autowired
    private LabourerRepository labourerRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void createLabourer(LabourerDTO labourerDTO) {
        Labourer labourer = modelMapper.map(labourerDTO, Labourer.class);
        labourerRepository.save(labourer);
    }

    @Override
    public void deleteLabourer(String id) {
        labourerRepository.deleteById(id);

    }

    @Override
    public Optional<LabourerDTO> getLabourer(String id) {
        Optional<Labourer> labourer = labourerRepository.findById(id);
        return Optional.of(modelMapper.map(labourer, LabourerDTO.class));
    }

    @Override
    public void updateLabourer(String id,LabourerDTO labourerDTO) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Labourer labourer = labourerRepository.findById(id).orElse(null);
        if (labourer == null){
            return;
        }
        modelMapper.map(labourerDTO,labourer);
        labourerRepository.save(labourer);
    }

    @Override
    public List<LabourerDTO> getLabourerList() {
        List<Labourer> labourerList = labourerRepository.findAll();
        return modelMapper.map(labourerList, new TypeToken<List<LabourerDTO>>() {}.getType());
    }


    @Override
    public List<LabourerDTO> getLabourerListByLocationAndSkill(String location, String skill) {
        List<Labourer> labourerList;
        if (location == null && skill == null){
            labourerList = labourerRepository.findAll();
        }else if (location == null){
            labourerList = labourerRepository.findAllBySkill(skill);
        }else if (skill == null) {
            labourerList = labourerRepository.findAllByLocation(location);
        }else {
            labourerList = labourerRepository.findAllByLocationAndSkill(location, skill);
        }
        return modelMapper.map(labourerList, new TypeToken<List<LabourerDTO>>() {}.getType());
    }
}
