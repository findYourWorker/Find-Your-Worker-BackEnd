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
public class RequestDTO {
    @Id
    private String id;
    private Long requestId;
    private String fullname;
    private String email;
    private String address;
    private String telNumber;
    private String nicNumber;
    private String servicedate;
    private String serviceType;
    private String description;
    private String recieptfile;
    @CreatedDate
    private Instant createdDate;
    @LastModifiedDate
    private Instant lastModifiedDate;
}
