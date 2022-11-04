package com.findyourworker.findyourworker.repository;


import com.findyourworker.findyourworker.entity.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends MongoRepository<Request,Integer> {

}
