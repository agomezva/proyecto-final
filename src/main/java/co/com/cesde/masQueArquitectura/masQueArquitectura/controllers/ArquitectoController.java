package co.com.cesde.masQueArquitectura.masQueArquitectura.controllers;

import co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service.ArquitectoService;
import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Arquitecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/arquitecto")
public class ArquitectoController {

    @Autowired
    private ArquitectoService arquitectoService;

    @GetMapping(value = "/listar")
    public List<Arquitecto> listarArquitecto(){
        return arquitectoService.getAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody Arquitecto arquitecto) {
        Optional<Arquitecto> arquitectoExiste = arquitectoService.findById(arquitecto.getIdArquitecto());
        if(arquitectoExiste.isPresent()){
            Arquitecto arquitectoAmodificar = arquitectoExiste.get();
            arquitectoAmodificar.setIdArquitecto(arquitecto.getIdArquitecto());
            arquitectoAmodificar.setNombre(arquitecto.getNombre());
            arquitectoAmodificar.setApellido(arquitecto.getApellido());
            arquitectoAmodificar.setTelefono(arquitecto.getTelefono());
            arquitectoAmodificar.setEmail(arquitecto.getEmail());

            arquitectoService.save(arquitectoAmodificar);

            return ResponseEntity.ok("El arquitecto fue modificado");
        }else{
            arquitectoService.save(arquitecto);
            return ResponseEntity.ok("El arquitecto fue creado");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Arquitecto> findById(@PathVariable(value = "id") Integer id) {
        Optional<Arquitecto> arquitectoExiste = arquitectoService.findById(id);


        return arquitectoExiste.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Integer id) {
        try{
            arquitectoService.deleteById(id);
            return ResponseEntity.ok("El arquitecto ha sido eliminado con exito");
        }catch (EmptyResultDataAccessException error){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro ningun arquitecto por el Id enviado");
        }
    }

}