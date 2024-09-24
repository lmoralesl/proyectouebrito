package aplicacion_nucleo1.aplicacion_nucleo1.servicio.Impl;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Cursos;
import aplicacion_nucleo1.aplicacion_nucleo1.repositorio.CursosRepositorio;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.CursosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosServicioImpl  implements CursosServicio {
    @Autowired
    private CursosRepositorio cursosRepositorio;

    @Override
    public List<Cursos> getAllCursos() {
        return cursosRepositorio.findAll();
    }

    @Override
    public Cursos getCursosById(Integer id) {
        return cursosRepositorio.findById(id).orElse(null);
    }

    @Override
    public Cursos saveOrUpdateCursos(Cursos cursos) {
        return cursosRepositorio.save(cursos);
    }

    @Override
    public boolean deleteCursos(Integer id) {
        if (cursosRepositorio.existsById(id)) {
            cursosRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}
