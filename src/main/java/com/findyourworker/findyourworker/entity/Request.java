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
    private String email;
    private String address;
    private String contactNumber;
    private String nic;
    private String service;
    private String serviceAbout;
    private String imageLink;

}
