package com.bridgelab.employeepayrollapp.services;

import com.bridgelab.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelab.employeepayrollapp.repository.EmployeeRepository;
import com.bridgelab.employeepayrollapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    //Creating Employee


    public Employee saveEmployee(EmployeePayrollDTO employeeDTO) {
        // Convert DTO to Entity
        Employee newEmployee = new Employee();
        newEmployee.setName(employeeDTO.getName());
        newEmployee.setSalary(employeeDTO.getSalary());
        newEmployee.setDepartment(employeeDTO.getDepartment());

        // Save Employee to Database
        return employeeRepository.save(newEmployee);
    }
    //Find employee by ID
    public Optional<Employee> getEmployeeById(Long id) {

        return employeeRepository.findById(id);
    }

   //Getting all employee
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Updating Employee data
    public Employee updateEmployee(long id, EmployeePayrollDTO employeeDTO) {
        // Find employee by ID or throw an exception if not found
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

        // Update employee details
        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setSalary(employeeDTO.getSalary());
        existingEmployee.setDepartment(employeeDTO.getDepartment());

        // Save updated employee
        return employeeRepository.save(existingEmployee);
    }


    // Deleting Employee data
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
