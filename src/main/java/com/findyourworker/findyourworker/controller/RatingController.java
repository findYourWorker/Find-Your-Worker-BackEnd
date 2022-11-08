package com.findyourworker.findyourworker.controller;

import com.findyourworker.findyourworker.dto.RatingDTO;

import com.findyourworker.findyourworker.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value="api/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/")
    public RatingDTO createRating(@RequestBody RatingDTO ratingDTO){
        return ratingService.createRating(ratingDTO);

    }
    @GetMapping("/")
    public List<RatingDTO> getRatings(){
        return ratingService.getAllRatings();
    }
}
