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
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String email;

    private String contrasena;

    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;

    @OneToMany(mappedBy = "usuario")
    private List<Token> tokens;
}
