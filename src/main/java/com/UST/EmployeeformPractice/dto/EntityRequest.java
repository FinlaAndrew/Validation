package com.UST.EmployeeformPractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityRequest {

    @NotNull(message = "name required")
    private String name;
    @Min(value = 24,message = "should be above 24")
    @Max(value = 42,message = "should be under 42")
    private int age;
    private String designation;

}
