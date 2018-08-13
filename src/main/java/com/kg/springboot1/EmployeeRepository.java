package com.kg.springboot1;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {
   // public Optional<Employee> findByEmployeeId(Long employeeId);
   // public List<Employee> findByDepartment(String department);
   // public List<Employee> findBySalaryLessThan(Long salary);
   // public List<Employee> findByDepartmentAndSalaryLessThan(String dept, Long
   // salary);

}