package com.UST.EmployeeformPractice.service;

import com.UST.EmployeeformPractice.dto.EntityRequest;
import com.UST.EmployeeformPractice.entity.EntityPractice;
import com.UST.EmployeeformPractice.exception.IdNotFoundException;
import com.UST.EmployeeformPractice.exception.NameFoundException;
import com.UST.EmployeeformPractice.repository.RepoPractice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class ServicePractice{

@Autowired
public RepoPractice repo;

        public EntityPractice postemp(EntityRequest request) {
            EntityPractice entity = new EntityPractice(0L, request.getName(), request.getAge(), request.getDesignation());
            Optional<EntityPractice> emp = repo.findByName(entity.getName());
            if(emp.isPresent()){
                throw new NameFoundException("Name already present");
            }
            else{
                return repo.save(entity);
            }

        }

        public List<EntityPractice> getemp() {
            return repo.findAll();
        }

        public EntityPractice getEmpById(Long id) {
            Optional<EntityPractice> emp1 = repo.findById(id);
            if(emp1.isEmpty()){
                throw new IdNotFoundException("id not found");
            }
            else{
                return repo.findById(id).orElse(null);
            }

        }

        public EntityPractice updateEmpById(EntityPractice ent) {
        // TODO Auto-generated method stub
        EntityPractice oldemp = null;
        Optional<EntityPractice> optionalemployee = repo.findById(ent.getId());
        if (optionalemployee.isPresent()) {
            oldemp = optionalemployee.get();
            oldemp.setName(ent.getName());
            //oldemp.setAddress(employee.getAddress());
            //oldemp.setLocation(employee.getLocation());
            repo.save(oldemp);
        } else {
            return new EntityPractice();
        }
        return oldemp;
    }
        public String deleteEmpById(Long id) {
            repo.deleteById(id);
            return "deleted..";
        }
}
