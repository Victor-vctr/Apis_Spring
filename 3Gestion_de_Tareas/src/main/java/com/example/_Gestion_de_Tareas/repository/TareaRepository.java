package com.example._Gestion_de_Tareas.repository;

import com.example._Gestion_de_Tareas.model.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


@Repository
public class TareaRepository implements ITareaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Tarea> rowMapper = (rs, rowNum) -> {
    Tarea tarea = new Tarea();
    tarea.setId(rs.getInt("id"));
    tarea.setTitulo(rs.getString("titulo"));
    tarea.setDescripcion(rs.getString("descripcion"));
    tarea.setCompletado(rs.getBoolean("completado"));
    tarea.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
    return tarea;
};


    @Async
    @Override
    public CompletableFuture<List<Tarea>> ListarTodas() {
        String sql = "SELECT * FROM tarea";
        List<Tarea> tareas = jdbcTemplate.query(sql, rowMapper);
        return CompletableFuture.completedFuture(tareas);
    }

    @Async
    @Override
    public CompletableFuture<Optional<Tarea>> buscarPorId(int id) {
        String sql = "SELECT * FROM tarea WHERE id = ?";
        List<Tarea> tareas = jdbcTemplate.query(sql, rowMapper, id);
        return CompletableFuture.completedFuture(tareas.stream().findFirst());
    }

    @Async
    @Override
    public CompletableFuture<Integer> guardar(Tarea tarea) {
        String sql = "INSERT INTO tarea (titulo, descripcion, completado) VALUES (?, ?, ?)";
        int filas = jdbcTemplate.update(sql, tarea.getTitulo(), tarea.getDescripcion(), tarea.isCompletado());
        return CompletableFuture.completedFuture(filas);
    }

    @Async
    @Override
    public CompletableFuture<Integer> actualizar(Tarea tarea) {
        String sql = "UPDATE tarea SET titulo = ?, descripcion = ?, completado = ? WHERE id = ?";
        int filas = jdbcTemplate.update(sql, tarea.getTitulo(), tarea.getDescripcion(), tarea.isCompletado(), tarea.getId());
        return CompletableFuture.completedFuture(filas);
    }

    @Async
    @Override
    public CompletableFuture<Integer> eliminar(int id) {
        String sql = "DELETE FROM tarea WHERE id = ?";
        int filas = jdbcTemplate.update(sql, id);
        return CompletableFuture.completedFuture(filas);
    }
}
