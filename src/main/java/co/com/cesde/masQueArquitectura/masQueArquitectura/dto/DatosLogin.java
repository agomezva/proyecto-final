package co.com.cesde.masQueArquitectura.masQueArquitectura.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DatosLogin {
    private String email;
    private String contrasena;
}
