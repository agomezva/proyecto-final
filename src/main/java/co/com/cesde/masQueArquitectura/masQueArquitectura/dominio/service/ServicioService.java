package co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service;

import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Servicio;
import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> getAll(){
        return servicioRepository.findAll();
    }

    public Servicio save(Servicio servicio){
        return servicioRepository.save(servicio);
    }

    public Optional<Servicio> findById(Integer id){
        return servicioRepository.findById(id);
    }

    public void deleteById(Integer id){
        servicioRepository.deleteById(id);
    }
}
