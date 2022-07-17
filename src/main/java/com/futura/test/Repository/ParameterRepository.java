package com.futura.test.Repository;

import com.futura.test.Entity.ParameterTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParameterRepository extends JpaRepository<ParameterTable, Long> {


    @Query(value = "select rule_description from parameter_table where rule_id = :ruleId", nativeQuery = true)
    List<String> getParameterwithRuleone(String ruleId);

}
