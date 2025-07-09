package com.example.calculadora.calculadora.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    @GetMapping("/sumar/{a}/{b}")
    public double sumarPath(@PathVariable double a, @PathVariable double b) {
        return a + b;
    }

    @GetMapping("/restar")
    public double restar(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("/multiplicar")
    public double multiplicar(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("/dividir")
    public double dividir(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }
}
