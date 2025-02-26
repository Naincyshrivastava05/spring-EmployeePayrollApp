package com.bridgelab.employeepayrollapp;

import com.bridgelab.employeepayrollapp.Employee;
import com.bridgelab.employeepayrollapp.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    // Get Employee by ID
    public Optional<Employee> getEmployeeById(Long id) {

        return employeeRepository.findById(id);
    }

    // List All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee newEmployeeData) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(newEmployeeData.getName());
            employee.setDepartment(newEmployeeData.getDepartment());
            employee.setSalary(newEmployeeData.getSalary());
            return employeeRepository.save(employee);
        }).orElse(null);
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
