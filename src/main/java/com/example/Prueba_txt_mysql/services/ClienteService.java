package com.example.Prueba_txt_mysql.services;

import com.example.Prueba_txt_mysql.models.Cliente;
import com.example.Prueba_txt_mysql.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class ClienteService {
    private  final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public List<Cliente> listAllCustomer(Cliente cliente){
       return  clienteRepository.listAllCustomer(cliente);
    }

    public String FileWrites(Cliente modelsParams) throws Exception {
        List<Cliente> clientes = clienteRepository.listAllCustomer(modelsParams);

        StringBuilder builder = new StringBuilder();

        for (Cliente cliente: clientes) {
            builder.append(cliente.getNombre() + "|");
            builder.append(cliente.getFechaInicio() + "|");
            builder.append("\n");
        }

       //.out.println(builder.toString());

        //writeFile("E://FileUpload//test.txt", clientes);
        return builder.toString();
    }

    public static void writeFile(String fileName,  List<Cliente> list) throws Exception {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(new File(fileName));
            bw = new BufferedWriter(fw);

            for (Cliente cliente: list) {
                bw.write(cliente.getNombre() + "|");
                bw.write(cliente.getFechaInicio() + "|");
                bw.write("\n");
            }



        } catch (Exception e) {
            System.out.println("YAWIN:ERROR:" + e.getMessage());
            throw e;
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
            }
            try {
                fw.close();
            } catch (Exception e) {
            }
        }

    }

    public byte[] read(File file) throws IOException {

        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        }finally {
            try {
                if (ous != null)
                    ous.close();
            } catch (IOException e) {
            }

            try {
                if (ios != null)
                    ios.close();
            } catch (IOException e) {
            }
        }
        return ous.toByteArray();
    }
}
