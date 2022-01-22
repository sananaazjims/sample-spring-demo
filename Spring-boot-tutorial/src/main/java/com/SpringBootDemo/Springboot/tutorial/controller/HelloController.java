package com.SpringBootDemo.Springboot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
// whatever things we are doing in the class it will be our rest end points
public class HelloController {

    //whenever we hit an end point we want this particular method to be execute so that we are using @getmapping for getting methods
  @GetMapping("/")
  public String helloworld(){
      return "welcome to IJ from SANA NAAZ";
  }

}
