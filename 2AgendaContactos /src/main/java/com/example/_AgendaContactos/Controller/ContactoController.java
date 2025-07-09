package com.example._AgendaContactos.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example._AgendaContactos.Service.IContactoService;
import com.example._AgendaContactos.models.Contacto;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    private final IContactoService contactoService;

    public ContactoController(IContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    public ResponseEntity<List<Contacto>> listarContactos() {
        List<Contacto> lista = contactoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacto> obtenerContacto(@PathVariable int id) {
        Optional<Contacto> contacto = contactoService.obtenerPorId(id);
        return contacto.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> crearContacto(@RequestBody Contacto contacto) {
        boolean creado = contactoService.guardar(contacto);
        if (creado) {
            return ResponseEntity.ok("Contacto creado exitosamente.");
        } else {
            return ResponseEntity.badRequest().body("Error al crear contacto.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarContacto(@PathVariable int id, @RequestBody Contacto contacto) {
        contacto.setId(id);
        boolean actualizado = contactoService.actualizar(contacto);
        if (actualizado) {
            return ResponseEntity.ok("Contacto actualizado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarContacto(@PathVariable int id) {
        boolean eliminado = contactoService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.ok("Contacto eliminado.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
