package co.com.cesde.masQueArquitectura.masQueArquitectura.dto;

import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DatosRegistro {
    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    private String contrasena;

    private String tipo;
}
