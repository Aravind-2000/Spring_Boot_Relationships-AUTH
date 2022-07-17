package com.futura.test.Repository;

import com.futura.test.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {


    @Query(value = "select * from skill where is_active = true", nativeQuery = true)
    List<Skill> getAllValidSkills();


}
