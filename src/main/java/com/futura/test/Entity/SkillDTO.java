package com.futura.test.Entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SkillDTO {

    private Long id;

    private String skillName;

    private String skillDesc;

    private List<String> enrolledEmployeeNames;

    private boolean isActive;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    private String modifiedUser;



}
