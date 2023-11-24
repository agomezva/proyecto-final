package co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service;

import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Cita;
import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> getAll(){return citaRepository.findAll();}

    public Cita save(Cita cita){
        return citaRepository.save(cita);
    }

    public Optional<Cita> finById(Integer id){
        return citaRepository.findById(id);
    }

    public void deleteById(Integer id) {

        citaRepository.deleteById(id);
    }

    public Optional<List<Cita>> findByIdArquitecto(Integer idArquitecto){

        return citaRepository.findByIdArquitecto(idArquitecto);
    }

    public List<Cita> getByDate(LocalDate fecha) {
        return citaRepository.findByFechaCita(fecha);
    }
}
