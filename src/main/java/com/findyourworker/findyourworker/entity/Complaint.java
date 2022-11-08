package com.findyourworker.findyourworker.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.Instant;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection="complaint")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EnableMongoAuditing
public class Complaint {
    @Transient
    public static final String SEQUENCE_NAME = "complaint_sequence";

    @Id
    private String id;
    private Long complaintId;
    private String name;
    private Date date;
    private String jobId;
    private String  employeeId;
    private String description;
    private String photo;
    @CreatedDate
    private Instant createdDate;
    @LastModifiedDate
    private Instant lastModifiedDate;
}
