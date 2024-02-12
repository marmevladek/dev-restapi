package com.project.devrestapi.request;

import lombok.Data;

@Data
public class EmployeeRequest {

    private Long id;
    private String name;
    private String email;
    private Long departmentId;

    private int wage;
}
