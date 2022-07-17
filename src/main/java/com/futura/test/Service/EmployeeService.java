package com.futura.test.Service;


import com.futura.test.Entity.Employee;
import com.futura.test.Entity.Skill;
import com.futura.test.Repository.EmployeeRepository;
import com.futura.test.Repository.SkillRepository;
import com.futura.test.error.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ErrorService errorService;


    public List<Employee> getAllEmployee(){
        return employeeRepository.getAllValidEmps();
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).get();
    }

    public String addEmployee(Employee employee){
        employee.setActive(true);
        employeeRepository.save(employee);
        return errorService.getErrorById("ER001");
    }

    public String updateEmployee(Long id, Employee newOne){

        Employee oldOne = employeeRepository.getById(id);

        if(newOne.getEmployeeCode() != null){
            oldOne.setEmployeeCode(newOne.getEmployeeCode());
        }

        if(newOne.getFirstName() != null){
            oldOne.setFirstName(newOne.getFirstName());
        }

        if(newOne.getLastName() != null){
            oldOne.setLastName(newOne.getLastName());
        }

        if(newOne.getDepartmentId() != null){
            oldOne.setDepartmentId(newOne.getDepartmentId());
        }

        if(newOne.getAddressId() != null){
            oldOne.setAddressId(newOne.getAddressId());
        }

        if(newOne.getGender() != null){
            oldOne.setGender(newOne.getGender());
        }

        if(newOne.getEmail() != null){
            oldOne.setEmail(newOne.getEmail());
        }

        if(newOne.getDateOfBirth() != null){
            oldOne.setDateOfBirth(newOne.getDateOfBirth());
        }
        employeeRepository.save(oldOne);
        return errorService.getErrorById("ER003");
    }

    public String softDeleteEmployee(Long id){
        Employee oldOne = employeeRepository.getById(id);
        oldOne.setActive(false);
        employeeRepository.save(oldOne);
        return errorService.getErrorById("ER003");
    }

    public String hardDeleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return errorService.getErrorById("ER003");
    }

    public String addSkillToEmployee(Long employeeId, Long skillId){
        if(employeeRepository.findById(employeeId).isPresent()){
            if(skillRepository.findById(skillId).isPresent()){
                Employee employee = employeeRepository.getById(employeeId);
                Skill skill = skillRepository.getById(skillId);
                if(!skill.getEnrolledEmployees().contains(employee)){
                    skill.enrollSkill(employee);
                    skillRepository.save(skill);
                    return errorService.getErrorById("ER001");
                }
                else{
                    return errorService.getErrorById("ER002");
                }
            }
        }
        return errorService.getErrorById("ER012");
    }

    public String deleteSkillFromEmployee(Long employeeId, Long skillId){
        Employee employee = employeeRepository.getById(employeeId);
        Skill skill = skillRepository.getById(skillId);
        skill.deleteSkill(employee);
        skillRepository.save(skill);
        return errorService.getErrorById("ER003");
    }

}
