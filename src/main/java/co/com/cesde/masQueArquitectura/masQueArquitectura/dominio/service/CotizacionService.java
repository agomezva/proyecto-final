package co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service;

import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Cotizacion;
import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.repository.CotizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CotizacionService {

    @Autowired
    private CotizacionRepository cotizacionRepository;

    public Cotizacion save(Cotizacion cotizacion){
        return cotizacionRepository.save(cotizacion);
    }

    public Optional<Cotizacion> findById(Integer id){
        return cotizacionRepository.findById(id);
    }

    public void deleteById(Integer id){
        cotizacionRepository.deleteById(id);
    }
}
