package com.findyourworker.findyourworker.service;

import com.findyourworker.findyourworker.dto.RatingDTO;


import java.util.List;

public interface RatingService {
    RatingDTO createRating(RatingDTO ratingDTO);
    List<RatingDTO> getAllRatings();
}
