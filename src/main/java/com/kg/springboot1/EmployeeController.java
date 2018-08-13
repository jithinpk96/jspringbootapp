package com.kg.springboot1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

/**
 * EmployeeController
 */
@RestController

@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // @RequestMapping(value = "/")
    // public Iterable<Employee> sample() {
    // return employeeRepository.findByDepartmentAndSalaryLessThan("DEPARTMENT6",
    // 5000L);

    // }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Employee> read() {
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public Optional<Employee> readOne(@PathVariable Long employeeId) {
        System.out.println(employeeRepository.findById(employeeId));
        return employeeRepository.findById(employeeId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee add(@RequestBody Employee employee) {
        employee.setEmployeeId(null);
        return employeeRepository.saveAndFlush(employee);
    }

    @RequestMapping(value = "{employeeId}", method = RequestMethod.PUT)
    public Employee update(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
        // Optional<Employee> employee = employeeRepository.findById(employeeId);
        updatedEmployee.setEmployeeId(employeeId);
        return employeeRepository.saveAndFlush(updatedEmployee);
    }

    @RequestMapping(value = "{employeeId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("employeeId") Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
