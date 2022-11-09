package com.findyourworker.findyourworker.repository;

import com.findyourworker.findyourworker.entity.Admin;
import com.findyourworker.findyourworker.entity.Labourer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin,String > {


    Admin findAdminByUsername(String username);
}
