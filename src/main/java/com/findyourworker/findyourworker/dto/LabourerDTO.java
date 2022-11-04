package com.findyourworker.findyourworker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class LabourerDTO {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String skill;
    private String phone;
    private Integer age;
    private String location;
}
