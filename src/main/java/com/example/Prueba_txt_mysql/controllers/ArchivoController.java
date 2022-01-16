package com.example.Prueba_txt_mysql.controllers;

import com.example.Prueba_txt_mysql.models.Cliente;
import com.example.Prueba_txt_mysql.services.ClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ArchivoController {


    private final ClienteService clienteService;

    public ArchivoController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String index(){
        return "index";
    }

    @PostMapping(value = "/list",produces = "application/json")
    public   @ResponseBody List<Cliente> listCustomer(@ModelAttribute Cliente cliente, Model model) {

        List<Cliente> list = clienteService.listAllCustomer(cliente);
        //list.add( new Cliente("0045450","00","00"));

        return list;
    }

    //@RequestMapping(value = "/download", method = RequestMethod.GET)
   // @RequestMapping("/txt/{fileName:.+}")
    @RequestMapping(value="/txt", method = RequestMethod.GET)
    public @ResponseBody void downloadFile(HttpServletResponse resp,
                                           @RequestParam("fileName") String fileName,
                                           @RequestParam("nroDocumento") String nroDocumento,
                                           @RequestParam("fechaInicio") String fechaInicio,
                                           @RequestParam("fechaFinal") String fechaFinal
                                           ) throws Exception {

        Cliente parameters = new Cliente();
        parameters.setNumeroDocumento(nroDocumento);
        parameters.setFechaInicio(fechaInicio);
        parameters.setFechaFinal(fechaFinal);


        String downloadStringContent= clienteService.FileWrites(parameters); // implement this
        try {
            OutputStream out = resp.getOutputStream();
            resp.setContentType("text/plain; charset=utf-8");
            resp.addHeader("Content-Disposition","attachment; filename=\"" + fileName + "\"");
            out.write(downloadStringContent.getBytes(Charset.forName("UTF-8")));
            out.flush();
            out.close();

        } catch (IOException e) {
        }
    }


}
