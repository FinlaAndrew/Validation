package com.UST.EmployeeformPractice.controller;

import com.UST.EmployeeformPractice.dto.EntityRequest;
import com.UST.EmployeeformPractice.entity.EntityPractice;
import com.UST.EmployeeformPractice.service.ServicePractice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
@Table(name="Employee details")
public class ControllerPractice {
    @Autowired
    public ServicePractice services;
    @PostMapping("/emp")
    public ResponseEntity<EntityPractice> post(@RequestBody @Valid EntityRequest request){
        return new ResponseEntity<>(services.postemp(request), HttpStatus.CREATED);
    }
    @GetMapping("/emp1")
    public List<EntityPractice> empp(){
        return services.getemp();
    }
    @GetMapping("/emp2/{id}")
    public EntityPractice getid(@PathVariable Long id){
        return services.getEmpById(id);
    }
    @PutMapping("/emp3/{id}")
    public EntityPractice updateid(@RequestBody EntityPractice ent){
        return services.updateEmpById(ent);
    }
    @DeleteMapping("/emp4/{id}")
    public String delete(@PathVariable Long id){
        return services.deleteEmpById(id);
    }
}
