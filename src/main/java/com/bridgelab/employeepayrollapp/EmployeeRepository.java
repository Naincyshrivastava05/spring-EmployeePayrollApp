package com.bridgelab.employeepayrollapp;
import com.bridgelab.employeepayrollapp.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

