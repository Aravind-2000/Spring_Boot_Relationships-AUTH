package com.futura.test.Repository;

import com.futura.test.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {


    @Query(value = "select * from department where is_active = true ", nativeQuery = true)
    List<Department> getAllValidDepts();


}
