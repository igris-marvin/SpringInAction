package com.example.mongodb.persistence.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "Employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    private String empno;

    @Field(targetType = FieldType.STRING)
    private String ename;
    private String job;
    private Double sal;

    private List<Location> locs;

    public Employee(
        String ename, 
        String job, 
        Double sal,
        List<Location> locs
    ) {
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.locs = locs;
    }
}
