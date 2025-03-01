package com.bridgelab.employeepayrollapp.services;

import com.bridgelab.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelab.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelab.employeepayrollapp.repository.EmployeeRepository;
import com.bridgelab.employeepayrollapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices implements IEmployeePayrollService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    //Creating Employee

@Override
    public Employee saveEmployee(EmployeePayrollDTO employeeDTO) {
    Employee employee = new Employee(employeeDTO);
        return employeeRepository.save(employee);
    }
    //Find employee by ID
    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Employee with ID " + id + " not found!"));
    }
   //Getting all employee
   @Override
   public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
   }

    // Updating Employee data
    @Override
    public Employee updateEmployee(long id, EmployeePayrollDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException("Employee not found with id: " + id));
        employee.updateEmployeePayrollModel(employeeDTO);
        return employeeRepository.save(employee);
    }


    // Deleting Employee data
    @Override
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
