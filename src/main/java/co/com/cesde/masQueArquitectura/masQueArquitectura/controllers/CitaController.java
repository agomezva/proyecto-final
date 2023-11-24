package co.com.cesde.masQueArquitectura.masQueArquitectura.controllers;

import co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service.CitaService;
import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Cita;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping(value = "/listar")
    public List<Cita> listarCitas(){
        return citaService.getAll();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody Cita cita){
        Optional<Cita> citaExiste = citaService.finById(cita.getIdCita());
        if (citaExiste.isPresent()){
            Cita citaAmodificar = citaExiste.get();
            citaAmodificar.setIdCita(cita.getIdCita());
            citaAmodificar.setIdArquitecto(cita.getIdArquitecto());
            citaAmodificar.setIdCliente(cita.getIdCliente());
            citaAmodificar.setFechaCita(cita.getFechaCita());
            citaAmodificar.setHoraInicio(cita.getHoraInicio());
            citaAmodificar.setHoraFinal(cita.getHoraFinal());

            citaService.save(citaAmodificar);

            return ResponseEntity.ok("La cita fue modificada");
        }else{
            citaService.save(cita);
            return ResponseEntity.ok("La cita fue agendada");
        }
    }

    @GetMapping(value = "/fecha")
    public ResponseEntity<List<Cita>> getByDate(@RequestBody LocalDate fecha){
        List<Cita> citas = citaService.getByDate(fecha);

        if(citas.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(citas);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cita> findById(@PathVariable(value = "id") Integer id){
        Optional<Cita> citaExiate = citaService.finById(id);

        return citaExiate.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Integer id) {
        try {
            citaService.deleteById(id);
            return ResponseEntity.ok("La cita ha sido eliminada");
        }catch (EmptyResultDataAccessException error){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontre ninguna cita con el Id enviado");

        }
    }

    @GetMapping(value = "/buscarArquitecto")
    public Optional<List<Cita>> findByIdArquitecto(Integer idArquitecto){

        return citaService.findByIdArquitecto(idArquitecto);
    }

}
