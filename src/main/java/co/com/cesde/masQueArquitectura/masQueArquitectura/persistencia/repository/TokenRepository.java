package co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.repository;

import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query("select t from Token t inner join Usuario u on t.usuario.idUsuario = u.idUsuario " +
            "where u.idUsuario = :idUsuario and (t.expirado = false or t.revocado = false)")
    List<Token> findAllValidTokensByUser(Integer idUsuario);

    Optional<Token> findByToken(String token);
}
