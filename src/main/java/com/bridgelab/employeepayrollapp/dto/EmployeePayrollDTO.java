package com.bridgelab.employeepayrollapp.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp ="[A-Z][a-zA-Z\\s]+$", message = "Name should start with capital letter")
    public String name;

    @Min(value = 1000, message ="salary should be atleast 1000")
    public  long salary;

    @NotNull(message = "Gender cannot be null")
    @Pattern(regexp = "Male|Female|Other", message = "Gender should be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Start Date cannot be null")
    @PastOrPresent(message = "Start Date should be in the past or present")
    private LocalDate startDate;

    private String note;

    private String profilePic;

    @NotEmpty(message = "Department cannot be empty")
    private List<String> department;


}