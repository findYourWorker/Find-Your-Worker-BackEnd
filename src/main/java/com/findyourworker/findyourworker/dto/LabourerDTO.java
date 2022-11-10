package com.findyourworker.findyourworker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Id;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class LabourerDTO {
    @Id
    private String id;
    private Long labourerId;
    private String firstname;
    private String lastname;
    private String active="1";
    @ElementCollection
    private List<String> skills;
    private String phone;
    private Integer age;
    private String location;
}
