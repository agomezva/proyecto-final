package co.com.cesde.masQueArquitectura.masQueArquitectura.controllers;

import co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service.CotizacionService;
import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Cotizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cotizacion")
public class CotizacionController {

    @Autowired
    private CotizacionService cotizacionService;

    //@GetMapping(value = "/listar")
    //public List<Cotizacion> listarCotizacion(){return cotizacionService.getAll();}

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cotizacion> findById(@PathVariable(value = "id") Integer id){
        Optional<Cotizacion> cotizacionExiste = cotizacionService.findById(id);

        return cotizacionExiste.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
