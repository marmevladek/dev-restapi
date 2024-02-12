package com.project.devrestapi.model;

import com.project.devrestapi.request.EmployeeRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name should not be null")
    private String name;


    @Email(message = "Enter the valid email address")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Wage wage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(EmployeeRequest req) {
        this.name = req.getName();
        this.email = req.getEmail();
    }


}
