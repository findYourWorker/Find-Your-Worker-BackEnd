package com.findyourworker.findyourworker.service.Impl;

import com.findyourworker.findyourworker.dto.LabourerDTO;
import com.findyourworker.findyourworker.entity.Labourer;
import com.findyourworker.findyourworker.repository.LabourerRepository;
import com.findyourworker.findyourworker.service.LabourerService;
import com.findyourworker.findyourworker.service.SequenceGeneratorService;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabourerServiceImpl implements LabourerService {

    @Autowired
    private LabourerRepository labourerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SequenceGeneratorService sequenceGenerator;


    @Override
    public void createLabourer(LabourerDTO labourerDTO) {
        Labourer labourer = modelMapper.map(labourerDTO, Labourer.class);
        labourer.setLabourerId(sequenceGenerator.generateSequence(Labourer.SEQUENCE_NAME));
        labourerRepository.save(labourer);
    }

    @Override
    public void deleteLabourer(String id) {
        labourerRepository.deleteById(id);

    }

    @Override
    public void deleteLabourerByLabourerId(Long labourerId) {
        labourerRepository.deleteByLabourerId(labourerId);
    }

    @Override
    public Optional<LabourerDTO> getLabourer(String id) {
        Optional<Labourer> labourer = labourerRepository.findById(id);
        return Optional.of(modelMapper.map(labourer, LabourerDTO.class));
    }

    @Override
    public LabourerDTO getLabourerByLabourerId(Long labourerId) {
        Optional<Labourer> labourer = labourerRepository.findByLabourerId(labourerId);
        return labourer.map(value -> modelMapper.map(value, LabourerDTO.class)).orElse(null);
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
    public void updateLabourerByLabourerId(Long labourerId, LabourerDTO labourerDTO) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Labourer labourer = labourerRepository.findByLabourerId(labourerId).orElse(null);
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
    public List<LabourerDTO> getLabourerListForAdmin(String skipp,String take) {
        int limit= Integer.parseInt(take);
        int skip=Integer.parseInt(skipp);
        System.out.println(limit+skip);

        List<Labourer> labourerList = labourerRepository.findAll();
        System.out.println(labourerList );
        return modelMapper.map(labourerList, new TypeToken<List<LabourerDTO>>() {}.getType());
    }


    @Override
    public List<LabourerDTO> getLabourerListByLocationSkillAndLabourerId(String location, String skill,Long labourerId, Pageable pageable) {
        List<Labourer> labourerList;
        if (location == null && skill == null && labourerId ==null){
            labourerList = labourerRepository.findAll(pageable).getContent();
        }else if (location == null && labourerId==null){
            labourerList = labourerRepository.findAllBySkills(skill,pageable);
        }else if (skill == null && labourerId==null) {
            labourerList = labourerRepository.findAllByLocation(location, pageable);
        } else if (skill==null && location==null) {
            labourerList = labourerRepository.findAllByLabourerId(labourerId, pageable);
        }
    else {
            labourerList = labourerRepository.findAllByLocationAndSkillsAndLabourerId(location, skill,labourerId,pageable);
        }
        return modelMapper.map(labourerList, new TypeToken<List<LabourerDTO>>() {}.getType());
    }

    @Override
    public List<LabourerDTO> getLabourerPaginate(Pageable pageable) {
        List<Labourer> labourerList = labourerRepository.findAll(pageable).getContent();
        return modelMapper.map(labourerList, new TypeToken<List<LabourerDTO>>() {}.getType());
    }


    @Override
    public long getAllLabourerCount(){
        return labourerRepository.count();
    }
}
