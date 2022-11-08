package com.findyourworker.findyourworker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComplaintDTO {
    @Id
    private String id;
    private Long complaintId;
    private String name;
    private Date date;
    private Long jobId;
    private Long  employeeId;
    private String description;
    private String photo;
    @CreatedDate
    private Instant createdDate;
    @LastModifiedDate
    private Instant lastModifiedDate;

}
