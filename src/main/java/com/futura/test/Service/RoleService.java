package com.futura.test.Service;


import com.futura.test.Entity.Role;
import com.futura.test.Repository.RoleRepository;
import com.futura.test.error.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ErrorService errorService;


    public String addRole(Role role){
        roleRepository.save(role);
        return errorService.getErrorById("ER001");
    }


}
