package com.practice.employee.service;

import com.practice.employee.entity.EmployeeInfo;
import com.practice.employee.repository.EmployeeRepository;
import com.practice.employee.response.EmployeeDetails;
import com.practice.employee.request.EmployeeRequest;
import com.practice.employee.response.GetEmployeeResponse;
import com.practice.employee.response.EmployeeResponse;
import com.practice.employee.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse registerEmployee(EmployeeRequest employeeRequest) {
        EmployeeResponse employeeResponse = new EmployeeResponse();

        EmployeeInfo employeeInfo = getEmployeeInfo(employeeRequest);
        EmployeeInfo employeeInfo1 = employeeRepository.save(employeeInfo);
        employeeResponse.setStatus(201);
        employeeResponse.setMessage("Employee registered successfully, the registration Id is: " + employeeInfo1.getId());

        return employeeResponse;
    }

    @Override
    public GetEmployeeResponse getEmployeeById(Long id) {
        Optional<EmployeeInfo> optionalEmployeeInfo = employeeRepository.findByEmpId(id);
        GetEmployeeResponse getEmployeeResponse = new GetEmployeeResponse();

        if (optionalEmployeeInfo.isEmpty()) {
            throw new EmployeeNotFoundException("Exception:: Employee not found with the given empId:" + id);
        } else {
            EmployeeDetails employeeDetails = getEmployeeDetails(optionalEmployeeInfo.get());
            getEmployeeResponse.setStatus(200);
            getEmployeeResponse.setMessage("These are the employee details:");
            getEmployeeResponse.setEmployeeDetails(employeeDetails);
        }
        return getEmployeeResponse;
    }

    @Override
    @Transactional
    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest) {

        Optional<EmployeeInfo> optionalEmployeeInfo = employeeRepository.findByEmpId(employeeRequest.getEmpId());
        EmployeeResponse employeeResponse = new EmployeeResponse();

        if (optionalEmployeeInfo.isEmpty()) {
            throw new EmployeeNotFoundException("Exception:: Employee not found with the given empId:" + employeeRequest.getEmpId());
        } else {
            EmployeeInfo employeeInfo = optionalEmployeeInfo.get();
            employeeRepository.delete(optionalEmployeeInfo.get());
            if(employeeRequest.getName()!=null){
                employeeInfo.setName(employeeRequest.getName());
            }
            if(employeeRequest.getSalary()!=null){
                employeeInfo.setSalary(employeeRequest.getSalary());
            }
            if(employeeRequest.getDob()!=null){
                employeeInfo.setDob(employeeRequest.getDob());
            }
            if(employeeRequest.getState()!=null){
                employeeInfo.setState(employeeRequest.getState());
            }
            if(employeeRequest.getCountry()!=null){
                employeeInfo.setCountry(employeeRequest.getCountry());
            }
            if(employeeRequest.getLine1()!=null){
                employeeInfo.setLine1(employeeRequest.getLine1());
            }
            if(employeeRequest.getLine2()!=null){
                employeeInfo.setLine2(employeeRequest.getLine2());
            }




            employeeRepository.save(employeeInfo);
            employeeResponse.setStatus(200);
            employeeResponse.setMessage("Update Successful");
        }
        return employeeResponse;
    }

    @Override
    public EmployeeResponse deleteEmployee(Long id) {

        Optional<EmployeeInfo> optionalEmployeeInfo = employeeRepository.findByEmpId(id);
        EmployeeResponse employeeResponse = new EmployeeResponse();

        if (optionalEmployeeInfo.isEmpty()) {
            throw new EmployeeNotFoundException("Exception:: Employee not found with the given empId:" + id);
        } else {
            employeeRepository.delete(optionalEmployeeInfo.get());

            employeeResponse.setMessage("Deletion successful");
            employeeResponse.setStatus(200);
        }

        return employeeResponse;
    }

//    public EmployeeResponse validateRequest(EmployeeRequest employeeRequest){
//        EmployeeResponse employeeResponse = new EmployeeResponse();
//        if(employeeRequest.getName().length()>50){
//            employeeResponse.setMessage("Name greater than 50 characters");
//            employeeResponse.setStatus(400);
//        }
//        if(employeeRequest.getSalary()>1000000){
//            employeeResponse.setMessage("Salary cannot be more than 10L");
//            employeeResponse.setStatus(400);
//        }
//        if(employeeRequest.getLine1().length()>50){
//            employeeResponse.setMessage("Line 1 cannot be more than 50 characters");
//            employeeResponse.setStatus(400);
//        }
//        if(employeeRequest.getLine2().length()>50){
//            employeeResponse.setMessage("Line 2 cannot be more than 50 characters");
//            employeeResponse.setStatus(400);
//        }
//        if(employeeRequest.getState().length()>2){
//            employeeResponse.setMessage("State cannot be more than 2 characters");
//            employeeResponse.setStatus(400);
//        }
//        if(employeeRequest.getCountry().length()>3){
//            employeeResponse.setMessage("Country cannot be more than 3 characters");
//            employeeResponse.setStatus(400);
//        }
//        return employeeResponse;
//    }


    //        Static methods
    private static EmployeeInfo getEmployeeInfo(EmployeeRequest employeeRequest) {
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmpId(employeeRequest.getEmpId());
        employeeInfo.setCountry(employeeRequest.getCountry());
        employeeInfo.setDob(employeeRequest.getDob());
        employeeInfo.setName(employeeRequest.getName());
        employeeInfo.setLine1(employeeRequest.getLine1());
        employeeInfo.setLine2(employeeRequest.getLine2());
        employeeInfo.setSalary(employeeRequest.getSalary());
        employeeInfo.setState(employeeRequest.getState());
        return employeeInfo;
    }

    private static EmployeeDetails getEmployeeDetails(EmployeeInfo employeeInfo) {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setEmpId(employeeInfo.getEmpId());
        employeeDetails.setCountry(employeeInfo.getCountry());
        employeeDetails.setName(employeeInfo.getName());
        employeeDetails.setDob(employeeInfo.getDob());
        employeeDetails.setSalary(employeeInfo.getSalary());
        employeeDetails.setState(employeeInfo.getState());
        employeeDetails.setLine1(employeeInfo.getLine1());
        employeeDetails.setLine2(employeeInfo.getLine2());
        return employeeDetails;
    }
}
