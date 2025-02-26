package com.bridgelab.employeepayrollapp.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class ResponseDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp ="[A-Z][a-zA-Z\\s]+$", message = "Name should start with capital letter")
    public String name;

    @Min(value = 1000, message ="salary should be atleast 1000")
    public  long salary;

    public ResponseDTO(String name, long salary){
        this.name = name;
        this.salary = salary;
    }
}
