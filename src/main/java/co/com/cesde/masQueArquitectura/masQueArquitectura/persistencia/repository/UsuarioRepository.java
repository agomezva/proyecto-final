package co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.repository;

import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
