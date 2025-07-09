package com.example._AgendaContactos.Repository;

import java.util.List;
import java.util.Optional;

import com.example._AgendaContactos.models.Contacto;

public interface IContactoRepository {
    List<Contacto> listarTodos();
    Optional<Contacto> obtenerPorId(int id);
    int guardar(Contacto contacto);
    int actualizar(Contacto contacto);
    int eliminar(int id);
}
