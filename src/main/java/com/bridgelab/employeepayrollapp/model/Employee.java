package com.bridgelab.employeepayrollapp.model;

import com.bridgelab.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

//Using lombok
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    private List<String> department;
    private double salary;

    public Employee(EmployeePayrollDTO dto) {
        this.updateEmployeePayrollModel(dto);
    }

    public void updateEmployeePayrollModel(EmployeePayrollDTO dto) {
        this.name = dto.getName();
        this.salary = dto.getSalary();
        this.gender = dto.getGender();
        this.startDate = dto.getStartDate();
        this.note = dto.getNote();
        this.profilePic = dto.getProfilePic();
        this.department = dto.getDepartment();
    }
}
