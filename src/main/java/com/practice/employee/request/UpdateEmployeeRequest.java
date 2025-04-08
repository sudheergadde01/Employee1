package com.practice.employee.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeRequest {

    private String name;
    private Float newSalary;
}
