package com.bridgelab.employeepayrollapp.model;

import com.bridgelab.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

//Using lombok
//tells Hibernate to create a   table
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "employee_id")
    private Long id;
    @Column(name= "name")
    private String name;
    @Column(name= "gender")
    private String gender;
    @Column(name= "startDate")
    private LocalDate startDate;

    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name ="employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name= "department")

    private List<String> department;
    @Column(name= "salary")
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
