package com.duda.make.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Teste")
public class TesteControler {


    @GetMapping
    public String testeApi(){
        return "Api funcionado";
    }


}
