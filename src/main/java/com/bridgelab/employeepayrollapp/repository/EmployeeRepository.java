package com.bridgelab.employeepayrollapp.repository;
import com.bridgelab.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository Interface to hold Employee Payroll Records.
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

