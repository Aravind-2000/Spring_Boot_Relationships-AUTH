package com.futura.test.Controller;



import com.futura.test.Entity.ParameterTable;
import com.futura.test.Service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/param")
public class ParameterController {

    @Autowired
    private ParameterService paramService;

    @GetMapping("/getall")
    public List<ParameterTable> getallparams(){
        return paramService.getAllParams();
    }

    @GetMapping("/{rule}")
    public List<String> getruleone(@PathVariable String rule){
        return paramService.getRuleOne(rule);
    }
}
