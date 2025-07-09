package com.example._Gestion_de_Tareas.service;

import com.example._Gestion_de_Tareas.model.Tarea;
import com.example._Gestion_de_Tareas.repository.ITareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TareaService implements ITareaService {

    @Autowired
    private ITareaRepository tareaRepository;

    @Async
    @Override
    public CompletableFuture<List<Tarea>> listarTodas() {
        return tareaRepository.ListarTodas();
    }

    @Async
    @Override
    public CompletableFuture<Optional<Tarea>> buscarPorId(int id) {
        return tareaRepository.buscarPorId(id);
    }

    @Async
    @Override
    public CompletableFuture<Integer> guardar(Tarea tarea) {
        return tareaRepository.guardar(tarea);
    }

    @Async
    @Override
    public CompletableFuture<Integer> actualizar(Tarea tarea) {
        return tareaRepository.actualizar(tarea);
    }

    @Async
    @Override
    public CompletableFuture<Integer> eliminar(int id) {
        return tareaRepository.eliminar(id);
    }
}