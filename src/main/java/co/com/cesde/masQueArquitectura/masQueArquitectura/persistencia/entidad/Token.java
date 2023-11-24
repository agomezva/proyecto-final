package co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Token {
    @Column(name = "id_token")
    private Integer idToken;
    private String token;
    private boolean revocado;
    private boolean expirado;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
