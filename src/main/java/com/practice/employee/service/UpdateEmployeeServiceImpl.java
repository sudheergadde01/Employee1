package com.practice.employee.service;

import com.practice.employee.entity.EmployeeInfo;
import com.practice.employee.repository.EmployeeRepository;
import com.practice.employee.request.DeleteEmployeeRequest;
import com.practice.employee.request.EmployeeDetails;
import com.practice.employee.request.UpdateEmployeeRequest;
import com.practice.employee.response.GetEmployeeResponse;
import com.practice.employee.response.UpdateEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UpdateEmployeeServiceImpl implements UpdateEmployeeService{

    private final EmployeeRepository employeeRepository;
    @Autowired
    public UpdateEmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }




    @Override
    @Transactional
    public UpdateEmployeeResponse updateEmployeeSalary(UpdateEmployeeRequest updateEmployeeRequest) {

        EmployeeInfo employeeInfo = employeeRepository.findByName(updateEmployeeRequest.getName());
        UpdateEmployeeResponse updateEmployeeResponse= new UpdateEmployeeResponse();
        if(employeeInfo==null){
            updateEmployeeResponse.setMessage("No record found with the given name");
            return updateEmployeeResponse;
        }
        employeeInfo.setSalary(updateEmployeeRequest.getNewSalary());

        EmployeeInfo employeeInfoUpdated = employeeRepository.save(employeeInfo);

        EmployeeDetails employeeDetails = getEmployeeDetails(employeeInfoUpdated);

        updateEmployeeResponse.setMessage("These are the updated employee details:");
        updateEmployeeResponse.setEmployeeDetails(employeeDetails);


        return updateEmployeeResponse;
    }

    private static EmployeeDetails getEmployeeDetails(EmployeeInfo employeeInfoUpdated) {
        EmployeeDetails employeeDetails= new EmployeeDetails();

        employeeDetails.setCountry(employeeInfoUpdated.getCountry());
        employeeDetails.setName(employeeInfoUpdated.getName());
        employeeDetails.setDob(employeeInfoUpdated.getDob());
        employeeDetails.setSalary(employeeInfoUpdated.getSalary());
        employeeDetails.setState(employeeInfoUpdated.getState());
        employeeDetails.setLine1(employeeInfoUpdated.getLine1());
        employeeDetails.setLine2(employeeInfoUpdated.getLine2());
        return employeeDetails;
    }

    @Override
    public GetEmployeeResponse deleteEmployee(DeleteEmployeeRequest deleteEmployeeRequest) {

        EmployeeInfo employeeInfo1 =employeeRepository.findByName(deleteEmployeeRequest.getName());
        GetEmployeeResponse getEmployeeResponse= new GetEmployeeResponse();
        if(employeeInfo1!=null) {
            employeeRepository.delete(employeeInfo1);
        }
        else {
            getEmployeeResponse.setMessage("Record not found for the given name.");
            return getEmployeeResponse;
        }
        EmployeeInfo employeeInfo = employeeRepository.findByName(deleteEmployeeRequest.getName());

        if(employeeInfo==null){
            getEmployeeResponse.setMessage("Deletion successful");
            return getEmployeeResponse;
        }

        getEmployeeResponse.setMessage("Deletion failed, the fetched record is:");
        getEmployeeResponse.setEmployeeDetails(getEmployeeDetails(employeeInfo));

        return getEmployeeResponse;
    }

}
