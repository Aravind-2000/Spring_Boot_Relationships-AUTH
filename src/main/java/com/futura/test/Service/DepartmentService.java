package com.futura.test.Service;


import com.futura.test.Entity.Department;
import com.futura.test.Repository.DepartmentRepository;
import com.futura.test.error.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ErrorService errorService;


    public List<Department> getAllDepartments(){
        return departmentRepository.getAllValidDepts();
    }

    public Department getDepartment(Long id){
        return departmentRepository.findById(id).get();
    }

    public String addDepartment(Department department){
        department.setActive(true);
        departmentRepository.save(department);
        return errorService.getErrorById("ER001");
    }

    public String updateDepartment(Long id, Department newOne){

        Department oldOne = departmentRepository.getById(id);

        if(newOne.getDepartmentName() != null){
            oldOne.setDepartmentName(newOne.getDepartmentName());
        }
        departmentRepository.save(oldOne);
        return errorService.getErrorById("ER003");
    }

    public String softDeleteDepartment(Long id){
        Department oldOne = departmentRepository.getById(id);
        oldOne.setActive(false);
        departmentRepository.save(oldOne);
        return errorService.getErrorById("ER003");
    }

    public String hardDeleteDepartment(Long id){
        departmentRepository.deleteById(id);
        return errorService.getErrorById("ER003");
    }




}
