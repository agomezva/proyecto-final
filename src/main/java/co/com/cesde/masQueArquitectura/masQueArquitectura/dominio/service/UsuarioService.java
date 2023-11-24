package co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service;

import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Usuario;
import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findById(Integer id) {
       return usuarioRepository.findById(id);
    }

    public void deleteById(Integer id){
        usuarioRepository.deleteById(id);
    }
}
