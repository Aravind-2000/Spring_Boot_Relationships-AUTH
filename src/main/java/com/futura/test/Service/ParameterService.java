package com.futura.test.Service;


import com.futura.test.Entity.ParameterTable;
import com.futura.test.Repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterService {

    @Autowired
    private ParameterRepository paramRepo;


    public List<ParameterTable> getAllParams(){
        return paramRepo.findAll();
    }

    public List<String> getRuleOne(String rule){
        return paramRepo.getParameterwithRuleone(rule);
    }

}
