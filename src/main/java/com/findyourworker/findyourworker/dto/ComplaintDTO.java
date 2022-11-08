package com.findyourworker.findyourworker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
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

}
