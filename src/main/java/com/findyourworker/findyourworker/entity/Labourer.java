package com.findyourworker.findyourworker.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection="labourers")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Labourer {
    @Transient
    public static final String SEQUENCE_NAME = "labourer_sequence";

    @Id
    private String id;
    private Long labourerId;
    private String firstname;
    private String lastname;
    @Builder.Default
    private String active="1";
    @ElementCollection
    private List<String> skills;
    private String phone;
    private Integer age;
    private String location;
}
