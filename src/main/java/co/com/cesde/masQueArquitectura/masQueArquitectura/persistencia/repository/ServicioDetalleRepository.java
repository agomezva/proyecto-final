package co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.repository;

import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.ServicioDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicioDetalleRepository extends JpaRepository<ServicioDetalle, Integer> {


    @Query("SELECT sd FROM ServicioDetalle sd WHERE sd.id.idCotizacion = :idCotizacion")
    List<ServicioDetalle> findByIdCotizacion(Integer idCotizacion);

}
