package com.findyourworker.findyourworker.repository;

import com.findyourworker.findyourworker.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository  extends MongoRepository<Rating,String> {
}
