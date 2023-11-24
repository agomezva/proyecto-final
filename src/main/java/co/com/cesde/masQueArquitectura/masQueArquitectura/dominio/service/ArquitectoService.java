package co.com.cesde.masQueArquitectura.masQueArquitectura.dominio.service;

import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.entidad.Arquitecto;
import co.com.cesde.masQueArquitectura.masQueArquitectura.persistencia.repository.ArquitectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArquitectoService {

    @Autowired
    private ArquitectoRepository arquitectoRepository;

    public List<Arquitecto> getAll(){
        return arquitectoRepository.findAll();
    }

    public Arquitecto save(Arquitecto arquitecto) {

        return arquitectoRepository.save(arquitecto);
    }

    public Optional<Arquitecto> findById(Integer id) {
        Optional<Arquitecto> arquiOptional = arquitectoRepository.findById(id);
        return arquiOptional;
    }

    public void deleteById(Integer id) {

        arquitectoRepository.deleteById(id);
    }
}
