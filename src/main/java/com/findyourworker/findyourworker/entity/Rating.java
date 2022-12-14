package com.findyourworker.findyourworker.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "rating")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Rating {
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
