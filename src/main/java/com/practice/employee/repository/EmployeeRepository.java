package com.practice.employee.repository;

import com.practice.employee.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Long> {
    Optional<EmployeeInfo> findByEmpId(Long empId);
}
