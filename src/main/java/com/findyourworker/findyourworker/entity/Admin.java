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
@Document(collection="admin")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Admin {
    @Id
    private String id;
    private String username;
    private String password;
}
