package com.example._AgendaContactos.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import com.example._AgendaContactos.models.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ContactoRepository implements IContactoRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContactoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Contacto> rowMapper = new RowMapper<Contacto>() {
        @Override
        public Contacto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contacto c = new Contacto();
            c.setId(rs.getInt("id"));
            c.setNombre(rs.getString("nombre"));
            c.setTelefono(rs.getString("telefono"));
            c.setEmail(rs.getString("email"));
            return c;
        }
    };

    @Override
    public List<Contacto> listarTodos() {
        String sql = "SELECT * FROM contactos";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Contacto> obtenerPorId(int id) {
        String sql = "SELECT * FROM contactos WHERE id = ?";
        List<Contacto> resultados = jdbcTemplate.query(sql, rowMapper, id);
        return resultados.stream().findFirst();
    }

    @Override
    public int guardar(Contacto contacto) {
        String sql = "INSERT INTO contactos (nombre, telefono, email) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, contacto.getNombre(), contacto.getTelefono(), contacto.getEmail());
    }

    @Override
    public int actualizar(Contacto contacto) {
        String sql = "UPDATE contactos SET nombre = ?, telefono = ?, email = ? WHERE id = ?";
        return jdbcTemplate.update(sql, contacto.getNombre(), contacto.getTelefono(), contacto.getEmail(), contacto.getId());
    }

    @Override
    public int eliminar(int id) {
        String sql = "DELETE FROM contactos WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}