package co.com.cesde.masQueArquitectura.masQueArquitectura.controllers;


import co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;
}
