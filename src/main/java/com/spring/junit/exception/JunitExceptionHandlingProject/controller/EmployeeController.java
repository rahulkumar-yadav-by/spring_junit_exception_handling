package com.spring.junit.exception.JunitExceptionHandlingProject.controller;

import com.spring.junit.exception.JunitExceptionHandlingProject.model.Employee;
import com.spring.junit.exception.JunitExceptionHandlingProject.service.EmployeeService;
import com.spring.junit.exception.JunitExceptionHandlingProject.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @RequestMapping(value = "/get-employees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(service.getEmployees(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get-employee-by-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee emp = service.getEmployeeById(id);
        if(emp==null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @RequestMapping(value = "/save-employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.OK);
    }

    @RequestMapping(value = "/save-all-employee", method = RequestMethod.POST)
    public ResponseEntity<List<Employee>> saveAllEmployees(@RequestBody List<Employee> employees) {
        return new ResponseEntity<>(service.saveAllEmployees(employees), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-employee/{id}", method = RequestMethod.DELETE)
    String removeEmployee(@PathVariable("id") Long id){
        return service.removeEmployee(id);
    }




}