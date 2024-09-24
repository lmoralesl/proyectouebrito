package aplicacion_nucleo1.aplicacion_nucleo1.servicio.Impl;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Aulas;
import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Profesores;
import aplicacion_nucleo1.aplicacion_nucleo1.repositorio.ProfesoresRepositorio;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.ProfesoresServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesoresServicioImpl  implements ProfesoresServicio {

    @Autowired
    private ProfesoresRepositorio profesoresRepositorio;

    @Override
    public List<Profesores> getAllProfesores() {
        return profesoresRepositorio.findAll();
    }

    @Override
    public List<Aulas> getAllAulas() {
        return List.of();
    }

    @Override
    public Profesores getProfesoresById(Integer id) {
        return profesoresRepositorio.findById(id).orElse(null);
    }

    @Override
    public Profesores saveOrUpdateProfesores(Profesores profesores) {
        return profesoresRepositorio.save(profesores);
    }

    @Override
    public boolean deleteProfesores(Integer id) {
        if (profesoresRepositorio.existsById(id)) {
            profesoresRepositorio.deleteById(id);
            return true;
        }
        return false;
    }

}
