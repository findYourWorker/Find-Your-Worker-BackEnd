package com.findyourworker.findyourworker.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection="complaint")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Complaint {
    @Transient
    public static final String SEQUENCE_NAME = "complaint_sequence";

    @Id
    private String id;
    private Long complaintId;
    private String name;
    private Date date;
    private Long jobId;
    private Long  employeeId;
    private String description;
    private String photo;
}