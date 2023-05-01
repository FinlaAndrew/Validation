package com.UST.EmployeeformPractice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EntityPractice {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;
    private String designation;

}
