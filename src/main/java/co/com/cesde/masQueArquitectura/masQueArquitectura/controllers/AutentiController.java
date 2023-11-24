package co.com.cesde.masQueArquitectura.masQueArquitectura.controllers;

import co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service.AutentiService;
import co.com.cesde.masQueArquitectura.masQueArquitectura.dto.DatosLogin;
import co.com.cesde.masQueArquitectura.masQueArquitectura.dto.DatosRegistro;
import co.com.cesde.masQueArquitectura.masQueArquitectura.dto.RespuestaAutenticacion;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autenti")
public class AutentiController {

    @Autowired
    private AutentiService autentiService;

    @PostMapping("/log")
    public ResponseEntity<RespuestaAutenticacion> iniciarSesion(@RequestBody DatosLogin datosLogin){
        return ResponseEntity.ok(autentiService.login(datosLogin));
    }

    @PostMapping("/registro")
    public ResponseEntity<RespuestaAutenticacion> registro(@RequestBody DatosRegistro datosRegistro){
        return ResponseEntity.ok(autentiService.registro(datosRegistro));
    }

}
