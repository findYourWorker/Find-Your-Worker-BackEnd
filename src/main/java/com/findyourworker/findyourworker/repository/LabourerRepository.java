package com.findyourworker.findyourworker.repository;


import com.findyourworker.findyourworker.entity.Labourer;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabourerRepository extends MongoRepository<Labourer,String> {
    List<Labourer> findAllByLocation(String location,Pageable pageable);
    List<Labourer> findAllBySkills(String skill,Pageable pageable);

    List<Labourer> findAllByLabourerId(Long labourerId, Pageable pageable);
    List<Labourer> findAllByLocationAndSkillsAndLabourerId(String location, String skill,Long labourerId,Pageable pageable);

    void deleteByLabourerId(Long labourerId);

    Optional<Labourer> findByLabourerId(Long labourerId);




//    @Aggregation("{'age': ?0},{'limit': ?1,'skip': ?2}")
//    List<Labourer> findLabourersByAge (int age,int limit,int skip);

}
