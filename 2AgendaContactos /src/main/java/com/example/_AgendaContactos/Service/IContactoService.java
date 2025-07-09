package com.example._AgendaContactos.Service;

import java.util.List;
import java.util.Optional;

import com.example._AgendaContactos.models.Contacto;

public interface IContactoService {
    List<Contacto> listarTodos();
    Optional<Contacto> obtenerPorId(int id);
    boolean guardar(Contacto contacto);
    boolean actualizar(Contacto contacto);
    boolean eliminar(int id);
}
