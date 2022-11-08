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
import javax.persistence.Transient;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "request")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {
    @Transient
    public static final String SEQUENCE_NAME = "request_sequence";
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
