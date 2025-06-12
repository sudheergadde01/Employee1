package com.practice.employee.controller;

import com.practice.employee.request.EmployeeRequest;
import com.practice.employee.response.GetEmployeeResponse;
import com.practice.employee.response.EmployeeResponse;
import com.practice.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/employee")
public class RegisterEmployeeController {

    private final EmployeeService employeeService;
    @Autowired
    public RegisterEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register-employee")
    public EmployeeResponse registerEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        System.out.println("/register-employee API working");
        return employeeService.registerEmployee(employeeRequest);
    }

    @GetMapping("/get-employee/{id}")
    public GetEmployeeResponse getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update-employee")
    public EmployeeResponse updateEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.updateEmployee(employeeRequest);
    }

    @DeleteMapping("/delete-employee/{id}")
    public EmployeeResponse deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
