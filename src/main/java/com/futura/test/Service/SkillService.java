package com.futura.test.Service;


import com.futura.test.Entity.Employee;
import com.futura.test.Entity.Skill;
import com.futura.test.Entity.SkillDTO;
import com.futura.test.Repository.SkillRepository;
import com.futura.test.error.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {


    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private ErrorService errorService;

    public List<SkillDTO> getAllSkills(){

        List<SkillDTO> skillDTOS = new ArrayList<>();
        List<Skill> skills = skillRepository.getAllValidSkills();
        skills.forEach(skill -> {
            SkillDTO skillDTO = mapEntityToDto(skill);
            skillDTOS.add(skillDTO);
        });
        return skillDTOS;
    }
    private SkillDTO mapEntityToDto(Skill skill){
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setId(skill.getId());
        skillDTO.setSkillName(skill.getSkillName());
        skillDTO.setSkillDesc(skill.getSkillDesc());
        skillDTO.setEnrolledEmployeeNames(skill.getEnrolledEmployees().stream().map(Employee::getFirstName).collect(Collectors.toList()));
        skillDTO.setActive(skill.isActive());
        skillDTO.setCreatedDate(skill.getCreatedDate());
        skillDTO.setLastUpdated(skill.getLastUpdated());
        skillDTO.setModifiedUser(skill.getModifiedUser());
        return skillDTO;
    }

    public SkillDTO getSkill(Long id){

        Skill skill = skillRepository.getById(id);
        return mapEntityToDto(skill);
    }

    public String addSkill(Skill skill){
        skill.setActive(true);
        skillRepository.save(skill);
        return errorService.getErrorById("ER001");
    }


    public String updateSkill(Long id, Skill newOne){

        Skill oldOne = skillRepository.getById(id);

        if(newOne.getSkillName() != null){
            oldOne.setSkillName(newOne.getSkillName());
        }

        if(newOne.getSkillDesc() != null){
            oldOne.setSkillDesc(newOne.getSkillDesc());
        }
        skillRepository.save(oldOne);
        return errorService.getErrorById("ER003");
    }

    public String softDeleteSkill(Long id){
        Skill oldOne = skillRepository.getById(id);
        oldOne.setActive(false);
        skillRepository.save(oldOne);
        return errorService.getErrorById("ER003");
    }


    public String hardDeleteSkill(Long id){
        skillRepository.deleteById(id);
        return errorService.getErrorById("ER003");
    }


}
