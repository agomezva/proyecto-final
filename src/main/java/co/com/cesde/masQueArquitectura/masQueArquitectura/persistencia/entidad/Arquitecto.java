package co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Arquitecto {
    @Id
    @Column(name = "id_arquitecto")
    private Integer idArquitecto;

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    @OneToMany(mappedBy = "arquitecto")
    private List<Cita> citas;

    @OneToMany(mappedBy = "arquitecto")
    private List<Cotizacion> cotizaciones;
}
