package com.futura.test.Controller;


import com.futura.test.Entity.Employee;
import com.futura.test.Repository.PermissionRepository;
import com.futura.test.Service.EmployeeService;
import com.futura.test.error.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {



    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ErrorService errorService;

    @Autowired
    private PermissionRepository permissionRepo;

    long programId = 1;

    @GetMapping("/getall/{userid}")
    public ResponseEntity<?> getAll(@PathVariable Long userid) {
        String method = "get-all-employee";
        if (!permissionRepo.isMethodPresent(userid, programId, method).isEmpty()) {
            return ResponseEntity.ok(employeeService.getAllEmployee());
        }
        return ResponseEntity.badRequest().body(errorService.getErrorById("ER007"));
    }

    @GetMapping("/{id}/{userid}")
    public ResponseEntity<?> getAll(@PathVariable Long userid, @PathVariable Long id) {
        String method = "get-employee";
        if (!permissionRepo.isMethodPresent(userid, programId, method).isEmpty()) {
            return ResponseEntity.ok(employeeService.getEmployee(id));
        }
        return ResponseEntity.badRequest().body(errorService.getErrorById("ER007"));
    }

    @PostMapping("/add/{userid}")
    public ResponseEntity<?> add(@PathVariable Long userid, @RequestBody Employee employee) {
        String method = "add-employee";
        if (!permissionRepo.isMethodPresent(userid, programId, method).isEmpty()) {
            return ResponseEntity.ok(employeeService.addEmployee(employee));
        }
        return ResponseEntity.ok().body(errorService.getErrorById("ER007"));
    }

    @PatchMapping("/{id}/{userid}")
    public ResponseEntity<?> update(@PathVariable Long userid, @RequestBody Employee employee, @PathVariable Long id) {
        String method = "update-employee";
        if (!permissionRepo.isMethodPresent(userid, programId, method).isEmpty()) {
            return ResponseEntity.ok(employeeService.updateEmployee(id,employee));
        }
        return ResponseEntity.ok().body(errorService.getErrorById("ER007"));
    }

    @PatchMapping("/softdelete/{id}/{userid}")
    public ResponseEntity<?> softDelete(@PathVariable Long userid, @PathVariable Long id) {
        String method = "soft-delete-employee";
        if (!permissionRepo.isMethodPresent(userid, programId, method).isEmpty()) {
            return ResponseEntity.ok(employeeService.softDeleteEmployee(id));
        }
        return ResponseEntity.ok().body(errorService.getErrorById("ER007"));
    }


    @DeleteMapping("/hardDelete/{id}/{userid}")
    public ResponseEntity<?> hardDelete(@PathVariable Long userid, @PathVariable Long id) {
        String method = "hard-delete-employee";
        if (!permissionRepo.isMethodPresent(userid, programId, method).isEmpty()) {
            return ResponseEntity.ok(employeeService.hardDeleteEmployee(id));
        }
        return ResponseEntity.ok().body(errorService.getErrorById("ER007"));
    }


    @PutMapping("/addskill/{employeeid}/{skillid}/{userid}")
    public ResponseEntity<?> addSkill(@PathVariable Long employeeid, @PathVariable Long skillid, @PathVariable Long userid){
        String method = "enroll-skill";
        if(!permissionRepo.isMethodPresent(userid, programId, method).isEmpty()){
            return ResponseEntity.ok(employeeService.addSkillToEmployee(employeeid, skillid));
        }
        return ResponseEntity.ok().body(errorService.getErrorById("ER007"));
    }

    @DeleteMapping("/removeskill/{employeeid}/{skillid}/{userid}")
    public ResponseEntity<?> removeSkill(@PathVariable Long employeeid, @PathVariable Long skillid, @PathVariable Long userid){
        String method = "remove-skill";
        if(!permissionRepo.isMethodPresent(userid, programId, method).isEmpty()){
            return ResponseEntity.ok(employeeService.deleteSkillFromEmployee(employeeid, skillid));
        }
        return ResponseEntity.ok().body(errorService.getErrorById("ER007"));
    }

}
