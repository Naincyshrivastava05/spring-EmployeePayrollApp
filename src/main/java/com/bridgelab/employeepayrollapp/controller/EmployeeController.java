package com.bridgelab.employeepayrollapp.controller;


import com.bridgelab.employeepayrollapp.services.EmployeeServices;
import com.bridgelab.employeepayrollapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bridgelab.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelab.employeepayrollapp.dto.ResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeService;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeService = employeeServices;
    }

    // Create Employee

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        Employee newEmployee = employeeService.saveEmployee(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee Created Successfully", newEmployee);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Get All Employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable long id, @Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee Updated Successfully", updatedEmployee);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id) ? "Deleted Successfully" : "Employee Not Found";
    }
}