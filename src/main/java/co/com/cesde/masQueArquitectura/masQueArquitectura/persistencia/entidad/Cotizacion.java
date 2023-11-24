package co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cotizacion {

    @Id
    @Column(name = "id_cotizacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCotizacion;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_cliente")
    private Integer idCliente;

    private LocalDate fecha;

    @Column(name = "precio_total")
    private Double precioTotal;

    @ManyToOne
    @JoinColumn(name = "id_usuario",insertable = false,updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_cliente",insertable = false,updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "cotizacion")
    private List<ServicioDetalle> detalleServicios;

}
