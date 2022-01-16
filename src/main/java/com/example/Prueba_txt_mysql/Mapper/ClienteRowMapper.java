package com.example.Prueba_txt_mysql.Mapper;

import com.example.Prueba_txt_mysql.models.Cliente;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ClienteRowMapper implements RowMapper<Cliente> {

    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setNombre(rs.getString("name"));
        cliente.setFechaInicio(rs.getString("created_at"));
        return  cliente;
    }
}
