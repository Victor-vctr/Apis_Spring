package com.example._Gestion_de_Tareas.repository;

import com.example._Gestion_de_Tareas.model.*;
import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.Optional;


public interface ITareaRepository {
    CompletableFuture<List<Tarea>> ListarTodas();
    CompletableFuture<Optional<Tarea>> buscarPorId(int id);
    CompletableFuture<Integer> guardar(Tarea tarea);
    CompletableFuture<Integer> actualizar(Tarea tarea);
    CompletableFuture<Integer> eliminar(int id);    
}