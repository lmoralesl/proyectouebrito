package aplicacion_nucleo1.aplicacion_nucleo1.servicio.Impl;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Aulas;
import aplicacion_nucleo1.aplicacion_nucleo1.repositorio.AulasRepositorio;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.AulasServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulasServicioImpl implements AulasServicio {

    @Autowired
    private AulasRepositorio aulasRepositorio;

    @Override
    public List<Aulas> getAllAulas() {
        return aulasRepositorio.findAll();
    }

    @Override
    public List<Aulas> getAllCursos() {
        return List.of();
    }

    @Override
    public Aulas getAulasById(Integer id) {
        return aulasRepositorio.findById(id).orElse(null);
    }

    @Override
    public Aulas saveOrUpdateAulas(Aulas aulas) {
        return aulasRepositorio.save(aulas);
    }

    @Override
    public boolean deleteAulas(Integer id) {
        if (aulasRepositorio.existsById(id)) {
            aulasRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}
