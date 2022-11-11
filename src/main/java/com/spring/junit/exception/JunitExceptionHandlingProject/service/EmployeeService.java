package com.spring.junit.exception.JunitExceptionHandlingProject.service;


import com.spring.junit.exception.JunitExceptionHandlingProject.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    List<Employee> saveAllEmployees(List<Employee> employees);

    void removeEmployee(Long id);
}
