package com.site.springMVC.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    //Validator
    /*можно вывести сообщение*/
//    @NotEmpty(message = "Name should be not be empty")
//    /*Можно указать параметры min max*/
//    @Size(min=1,message = "Name should be between 2 and 30 characters")
//    @Min(value = 0,message = "Min  number : zero")
    private int id;
    //@Email - удобная аннотация с регексом на борту
    @Size(min = 2,max = 10,message = "Not corrected, you need 2 - 10 words")
    private String name;
}
