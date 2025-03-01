package com.bridgelab.employeepayrollapp.repository;
import com.bridgelab.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repository Interface to hold Employee Payroll Records.
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM EmployeePayrollModel e WHERE :department MEMBER OF e.department")
    List<Employee> findEmployeesByDepartment(@Param("department") String department);
}

