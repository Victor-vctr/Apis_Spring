package com.example._Gestion_de_Tareas.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import com.example._Gestion_de_Tareas.model.Tarea;

public interface ITareaService {
    CompletableFuture<List<Tarea>> listarTodas();
    CompletableFuture<Optional<Tarea>> buscarPorId(int id);
    CompletableFuture<Integer> guardar(Tarea tarea);
    CompletableFuture<Integer> actualizar(Tarea tarea);
    CompletableFuture<Integer> eliminar(int id);
}
