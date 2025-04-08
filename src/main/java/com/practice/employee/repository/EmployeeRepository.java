package com.practice.employee.repository;

import com.practice.employee.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Long> {
    EmployeeInfo findByName(String name);
}
