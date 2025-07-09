package com.example._Gestion_de_Tareas.controller;

import com.example._Gestion_de_Tareas.model.Tarea;
import com.example._Gestion_de_Tareas.service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private ITareaService tareaService;

    @GetMapping
    public CompletableFuture<List<Tarea>> listarTodas() {
        return tareaService.listarTodas();
    }

    @GetMapping("/{id}")
    public CompletableFuture<Optional<Tarea>> obtenerPorId(@PathVariable int id) {
        return tareaService.buscarPorId(id);
    }

    @PostMapping
    public CompletableFuture<Integer> guardar(@RequestBody Tarea tarea) {
        return tareaService.guardar(tarea);
    }

    @PutMapping("/{id}")
    public CompletableFuture<Integer> actualizar(@PathVariable int id, @RequestBody Tarea tarea) {
        tarea.setId(id);
        return tareaService.actualizar(tarea);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Integer> eliminar(@PathVariable int id) {
        return tareaService.eliminar(id);
    }
}