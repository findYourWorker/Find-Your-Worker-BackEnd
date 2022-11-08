package com.findyourworker.findyourworker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RatingDTO {
    @Id
    private String id;
    private String comment;
    private String name;
    private Float rate;
}
