package co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ServicioDetallePK implements Serializable {

    @Column(name = "id_cotizacion")
    private Integer idCotizacion;

    @Column(name = "id_servicio")
    private Integer idServicio;

}
