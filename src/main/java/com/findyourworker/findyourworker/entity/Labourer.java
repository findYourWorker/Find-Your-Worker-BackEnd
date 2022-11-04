package com.findyourworker.findyourworker.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection="labourers")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Labourer {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String skill;
    private String phone;
    private Integer age;
    private String location;
}
