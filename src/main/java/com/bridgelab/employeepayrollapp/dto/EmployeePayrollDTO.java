package com.bridgelab.employeepayrollapp.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Pattern(regexp = "^(Male|Female)$", message = "Gender must be either Male or Female")
    private String gender;

    @NotNull(message = "Start Date cannot be null")
    @PastOrPresent(message = "Start Date must be a past or present date")
    @JsonFormat(pattern = "dd-MM-yyyy")  // Converts input date format
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "Profile picture URL cannot be empty")
    private String profilePic;

    @NotNull(message = "Department cannot be null")
    @Size(min = 1, message = "At least one department must be selected")
    private List<String> department;


}