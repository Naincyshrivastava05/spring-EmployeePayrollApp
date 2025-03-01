package com.bridgelab.employeepayrollapp.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class EmployeePayrollDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp ="[A-Z][a-zA-Z\\s]+$", message = "Name should start with capital letter")
    public String name;

    @Min(value = 1000, message ="salary should be atleast 1000")
    public  long salary;

    @NotEmpty(message = "Department cannot be empty")
    private String department;

    public EmployeePayrollDTO(String name, long salary, String department){
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}