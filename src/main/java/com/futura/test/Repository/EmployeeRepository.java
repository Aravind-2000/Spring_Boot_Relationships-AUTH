package com.futura.test.Repository;

import com.futura.test.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "select * from employee where is_active = true", nativeQuery = true)
    List<Employee> getAllValidEmps();

}
