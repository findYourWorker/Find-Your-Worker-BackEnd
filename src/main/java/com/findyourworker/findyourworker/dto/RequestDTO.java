package com.findyourworker.findyourworker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDTO {
    @Id
    private int id;
    private String email;
    private String address;
    private String contactNumber;
    private String nic;
    private int service;
    private String serviceAbout;
    private String imageLink;
}
