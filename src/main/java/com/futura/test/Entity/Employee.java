package com.futura.test.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "employee")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String employeeCode;

    private String firstName;
    private String lastName;
    private String gender;


    @JsonFormat(pattern = "MM-dd-yyyy HH:mm")
    private LocalDateTime dateOfBirth;

    private String email;

    private Long departmentId;

    private Long addressId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId", insertable = false, updatable = false)
    private Address address;

    @ManyToMany(mappedBy = "enrolledEmployees")
    private List<Skill> skills = new ArrayList<>();

    private boolean isActive;


    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    private String modifiedUser;

//    public void enrollSkill(Skill skill){
//        skills.add(skill);
//    }
//
//    public void deleteSkill(Skill skill){
//        skills.remove(skill);
//    }

}
