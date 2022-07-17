package com.futura.test.Controller;

import com.futura.test.Entity.Role;
import com.futura.test.Repository.RoleRepository;
import com.futura.test.error.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/role")
@RestController
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private ErrorService errorService;


    @GetMapping("/getall")
    public List<Role> getAllRoles(){
        return roleRepo.findAll();
    }

    @PostMapping("/add")
    public String addRoles(@RequestBody Role role){
        roleRepo.save(role);
        return errorService.getErrorById("ER001");
    }

}
