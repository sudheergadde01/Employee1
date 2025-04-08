package com.practice.employee.service;

import com.practice.employee.entity.EmployeeInfo;
import com.practice.employee.repository.EmployeeRepository;
import com.practice.employee.request.EmployeeDetails;
import com.practice.employee.request.GetEmployeeRequest;
import com.practice.employee.request.RegisterEmployeeRequest;
import com.practice.employee.response.GetEmployeeResponse;
import com.practice.employee.response.RegisterEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterEmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public RegisterEmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public RegisterEmployeeResponse registerEmployee(RegisterEmployeeRequest registerEmployeeRequest){
        RegisterEmployeeResponse registerEmployeeResponse = validateRequest(registerEmployeeRequest);
        if(registerEmployeeResponse.getStatus()==400){
            return registerEmployeeResponse;
        }
        EmployeeInfo employeeInfo = getEmployeeInfo(registerEmployeeRequest);
        EmployeeInfo employeeInfo1 =employeeRepository.save(employeeInfo);
        registerEmployeeResponse.setStatus(200);
        registerEmployeeResponse.setMessage("Employee registered successfully, the registration Id is: "+employeeInfo1.getId());

        return registerEmployeeResponse;
    }

    private static EmployeeInfo getEmployeeInfo(RegisterEmployeeRequest registerEmployeeRequest) {
        EmployeeInfo employeeInfo=new EmployeeInfo();
        employeeInfo.setCountry(registerEmployeeRequest.getCountry());
        employeeInfo.setDob(registerEmployeeRequest.getDob());
        employeeInfo.setName(registerEmployeeRequest.getName());
        employeeInfo.setLine1(registerEmployeeRequest.getLine1());
        employeeInfo.setLine2(registerEmployeeRequest.getLine2());
        employeeInfo.setSalary(registerEmployeeRequest.getSalary());
        employeeInfo.setState(registerEmployeeRequest.getState());
        return employeeInfo;
    }

    @Override
    public GetEmployeeResponse getEmployee(GetEmployeeRequest getEmployeeRequest) {
        EmployeeInfo employeeInfo = employeeRepository.findByName(getEmployeeRequest.getName());
        GetEmployeeResponse getEmployeeResponse = new GetEmployeeResponse();

        if (employeeInfo==null) {
            getEmployeeResponse.setMessage("No employee found with the given nameThese are the employee Details:");
            return getEmployeeResponse;
        }

        getEmployeeResponse.setMessage("No employee found with the given name");


        EmployeeDetails employeeDetails= new EmployeeDetails();
        employeeDetails.setCountry(employeeInfo.getCountry());
        employeeDetails.setName(employeeInfo.getName());
        employeeDetails.setDob(employeeInfo.getDob());
        employeeDetails.setSalary(employeeInfo.getSalary());
        employeeDetails.setState(employeeInfo.getState());
        employeeDetails.setLine1(employeeInfo.getLine1());
        employeeDetails.setLine2(employeeInfo.getLine2());


        getEmployeeResponse.setEmployeeDetails(employeeDetails);

        return getEmployeeResponse;
    }

    public RegisterEmployeeResponse validateRequest(RegisterEmployeeRequest registerEmployeeRequest){
        RegisterEmployeeResponse registerEmployeeResponse = new RegisterEmployeeResponse();
        if(registerEmployeeRequest.getName().length()>50){
            registerEmployeeResponse.setMessage("Name greater than 50 characters");
            registerEmployeeResponse.setStatus(400);
        }
        if(registerEmployeeRequest.getSalary()>1000000){
            registerEmployeeResponse.setMessage("Salary cannot be more than 10L");
            registerEmployeeResponse.setStatus(400);
        }
        if(registerEmployeeRequest.getLine1().length()>50){
            registerEmployeeResponse.setMessage("Line 1 cannot be more than 50 characters");
            registerEmployeeResponse.setStatus(400);
        }
        if(registerEmployeeRequest.getLine2().length()>50){
            registerEmployeeResponse.setMessage("Line 2 cannot be more than 50 characters");
            registerEmployeeResponse.setStatus(400);
        }
        if(registerEmployeeRequest.getState().length()>2){
            registerEmployeeResponse.setMessage("State cannot be more than 2 characters");
            registerEmployeeResponse.setStatus(400);
        }
        if(registerEmployeeRequest.getCountry().length()>3){
            registerEmployeeResponse.setMessage("Country cannot be more than 3 characters");
            registerEmployeeResponse.setStatus(400);
        }
        return registerEmployeeResponse;
    }

}
