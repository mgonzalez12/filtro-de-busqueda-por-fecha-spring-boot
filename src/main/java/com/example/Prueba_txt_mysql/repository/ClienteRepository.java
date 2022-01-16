package com.example.Prueba_txt_mysql.repository;

import com.example.Prueba_txt_mysql.Mapper.ClienteRowMapper;
import com.example.Prueba_txt_mysql.models.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {

    private JdbcTemplate jdbcTemplate;

    public ClienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cliente> listAllCustomer(Cliente cliente){
        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM mydatabase.tbl_laptops");
            //query.append("SELECT * FROM mydatabase.tbl_laptops where dni = '"+ cliente.getNumeroDocumento() + "'");
            // query.append(" SELECT * FROM mydatabase.tbl_laptops WHERE dni='"+ cliente.getNumeroDocumento() + "' and created_at BETWEEN '"
            //                + cliente.getFechaInicio() + "' AND '" +cliente.getFechaFinal() + "'" );

          //  query.append("WHERE 1 = 1");
          //  UtilQuerySQL.whereNumero(query, "CP.COD_PRODUCTO", objBean.getCodigoProducto());

            List<Cliente> listaCliente =  jdbcTemplate.query(query.toString(), new ClienteRowMapper());
            return listaCliente;

        }catch (Exception ex)
        {
            ex.printStackTrace();
            throw  ex;
        }
    }
}
