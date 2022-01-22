package com.SpringBootDemo.Springboot.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data //this @Data have everything getter setters constructor and to string method it belongs to lombok
@NoArgsConstructor //DEFAULT CONSTRUCTOR IS CREATED OVER HERE
@AllArgsConstructor //it have all agr constructor
@Builder
public class Department {
  //to create primary key for departmentId we need to define @Id and @GeneratedValue

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    //to get the departmentName compulsory we first need to add hibernate validation in pom
    //then here we need to add the @NotBlank and send message
    @NotBlank(message = "please Add Department Name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
