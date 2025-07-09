package com.example.calculadora.calculadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class Holacontroller {
    @GetMapping
    public String getMethodName() {
        return "Hola mundo";
    }
    @GetMapping("/nombre/{nombre}")
    public String getMethodName(@PathVariable String nombre) {
        return "Hola " + nombre;
    }
    @GetMapping("/sumar/{a}/{b}")
    public double sumar(@PathVariable double a, @PathVariable double b) {
        return a + b;
    }
    @GetMapping("/multi")
    public double multiplicar(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }
    @GetMapping("/mujer")
    public String saludarmujer(@RequestParam String param) {
        return "Hola mujer de Nombre: " + param;
    }
      
}
