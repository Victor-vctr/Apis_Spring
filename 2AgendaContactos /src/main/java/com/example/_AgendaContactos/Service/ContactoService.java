package com.example._AgendaContactos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example._AgendaContactos.Repository.IContactoRepository;
import com.example._AgendaContactos.models.Contacto;

@Service
public class ContactoService implements IContactoService {

    private final IContactoRepository contactoRepository;

    public ContactoService(IContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    @Override
    public List<Contacto> listarTodos() {
        return contactoRepository.listarTodos();
    }

    @Override
    public Optional<Contacto> obtenerPorId(int id) {
        return contactoRepository.obtenerPorId(id);
    }

    @Override
    public boolean guardar(Contacto contacto) {
        return contactoRepository.guardar(contacto) > 0;
    }

    @Override
    public boolean actualizar(Contacto contacto) {
        return contactoRepository.actualizar(contacto) > 0;
    }

    @Override
    public boolean eliminar(int id) {
        return contactoRepository.eliminar(id) > 0;
    }
}
