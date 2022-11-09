package com.findyourworker.findyourworker.repository;


import com.findyourworker.findyourworker.entity.Labourer;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabourerRepository extends MongoRepository<Labourer,String> {
    List<Labourer> findAllByLocation(String location);
    List<Labourer> findAllBySkills(String skill);
    List<Labourer> findAllByLocationAndSkills(String location, String skill);

    void deleteByLabourerId(Long labourerId);

    Optional<Labourer> findByLabourerId(Long labourerId);

//    @Aggregation("{'limit': ?0,'skip': ?1}")
//    List<Labourer> findLabourersBy (int limit,int skip);

}
