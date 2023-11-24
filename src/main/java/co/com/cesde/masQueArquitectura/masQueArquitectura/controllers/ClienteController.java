package co.com.cesde.masQueArquitectura.masQueArquitectura.controllers;

import co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service.ClienteService;
import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @GetMapping(value = "/listar")
    public List<Cliente> listarCliente(){
        return clienteService.getAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody Cliente cliente){
        Optional<Cliente> clienteExiste = clienteService.findById(cliente.getIdCliente());
        if (clienteExiste.isPresent()){
            Cliente clinteAmodificar = clienteExiste.get();
            clinteAmodificar.setIdCliente(cliente.getIdCliente());
            clinteAmodificar.setNombre(cliente.getNombre());
            clinteAmodificar.setApellido(cliente.getApellido());
            clinteAmodificar.setTelefono(cliente.getTelefono());
            clinteAmodificar.setEmail(cliente.getEmail());

            clienteService.save(clinteAmodificar);
            return ResponseEntity.ok("El cliente fue modificado");
        }else{
            clienteService.save(cliente);
            return ResponseEntity.ok("El cliente fue creado");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable(value = "id") Integer id){
        Optional<Cliente> clienteExiste = clienteService.findById(id);

        return clienteExiste.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(value = "/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Integer id){
        try {
            clienteService.deleteById(id);
            return ResponseEntity.ok("El cliente ha sido eliminado con exito");
        }catch (EmptyResultDataAccessException error){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro ningun cliente por el Id enviado");
        }

    }


}
