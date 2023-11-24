package co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    private Integer idCliente;

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Cita> citas;

    @OneToMany(mappedBy = "cliente")
    private List<Cotizacion> cotizaciones;

}
