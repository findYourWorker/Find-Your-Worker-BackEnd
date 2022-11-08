package com.findyourworker.findyourworker.service.Impl;

import com.findyourworker.findyourworker.dto.RatingDTO;

import com.findyourworker.findyourworker.entity.Rating;


import com.findyourworker.findyourworker.repository.RatingRepository;

import com.findyourworker.findyourworker.service.RatingService;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RatingDTO createRating(RatingDTO ratingDTO) {
        ratingRepository.insert(modelMapper.map(ratingDTO, Rating.class));
        return ratingDTO;
    }

    @Override
    public List<RatingDTO> getAllRatings() {
        List<Rating>ratingList=ratingRepository.findAll();
        return modelMapper.map(ratingList,new TypeToken<List<RatingDTO>>(){}.getType());
    }
}
