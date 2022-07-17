package com.futura.test.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "skill")
@Getter
@Setter
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;

    private String skillDesc;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "enrolled_employees",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> enrolledEmployees = new ArrayList<>();

    private boolean isActive;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    private String modifiedUser;

    public void enrollSkill(Employee employee){
        enrolledEmployees.add(employee);
    }

    public void deleteSkill(Employee employee){
        enrolledEmployees.remove(employee);
    }
}
