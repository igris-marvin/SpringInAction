package com.example.mongodb.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String empno;
    private String ename;
    private String job;
    private String sal;
    private List<String> locs;
}
