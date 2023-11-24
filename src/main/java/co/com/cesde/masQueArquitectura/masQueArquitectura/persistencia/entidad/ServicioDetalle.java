package co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "servicio_detalle")
public class ServicioDetalle {

    @EmbeddedId
    private ServicioDetallePK id;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_cotizacion",insertable = false,updatable = false)
    private Cotizacion cotizacion;

    @ManyToOne
    @JoinColumn(name = "id_servio",insertable = false,updatable = false)
    private Servicio servicio;


}
