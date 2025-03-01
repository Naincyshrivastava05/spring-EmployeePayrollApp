package com.bridgelab.employeepayrollapp.services;


import com.bridgelab.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelab.employeepayrollapp.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee saveEmployee(EmployeePayrollDTO employeePayrollDTO);
    Employee updateEmployee(long id, EmployeePayrollDTO employeePayrollDTO);
    boolean deleteEmployee(Long id);
}
