package com.bridgelab.employeepayrollapp.services;

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


    //Creating Employee
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
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
    public Employee updateEmployee(Long id, Employee newEmployeeData) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(newEmployeeData.getName());
            employee.setDepartment(newEmployeeData.getDepartment());
            employee.setSalary(newEmployeeData.getSalary());
            return employeeRepository.save(employee);
        }).orElse(null);
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
