package com.findyourworker.findyourworker.repository;


import com.findyourworker.findyourworker.entity.Labourer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabourerRepository extends MongoRepository<Labourer,String> {
    List<Labourer> findAllByLocation(String location);
    List<Labourer> findAllBySkill(String skill);
    List<Labourer> findAllByLocationAndSkill(String location, String skill);
}
