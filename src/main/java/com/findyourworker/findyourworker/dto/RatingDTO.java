package com.findyourworker.findyourworker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Id;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RatingDTO {
    @Id
    private String id;
    private String comment;
    private String name;
    private Float rate;
    @CreatedDate
    private Instant createdDate;
    @LastModifiedDate
    private Instant lastModifiedDate;
}
