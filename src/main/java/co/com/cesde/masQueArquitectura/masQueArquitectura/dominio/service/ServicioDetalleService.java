package co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service;

import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.ServicioDetalle;
import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.repository.ServicioDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioDetalleService {

    @Autowired
    private ServicioDetalleRepository servicioDetalleRepository;

    public ServicioDetalle save(ServicioDetalle servicioDetalle){
        return servicioDetalleRepository.save(servicioDetalle);
    }

    public Optional<ServicioDetalle> findById(Integer id){
        return servicioDetalleRepository.findById(id);
    }

    public List<ServicioDetalle> findByIdCotizacion(Integer idCotizacion){
        return servicioDetalleRepository.findByIdCotizacion(idCotizacion);
    }

    public void deleteById(Integer id){
        servicioDetalleRepository.deleteById(id);
    }


}
