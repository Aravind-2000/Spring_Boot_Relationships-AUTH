package com.futura.test.Controller;


import com.futura.test.Entity.Service;
import com.futura.test.Repository.ServiceRespository;
import com.futura.test.error.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/service")
@CrossOrigin
@RestController
public class ServiceController {


    @Autowired
    private ServiceRespository serviceRespository;

    @Autowired
    private ErrorService errorService;

    @GetMapping("/getall")
    public List<Service> getAllServices(){
        return serviceRespository.findAll();
    }

    @PostMapping("/add")
    public String addService(@RequestBody Service service){
        serviceRespository.save(service);
        return errorService.getErrorById("ER001");
    }
}
