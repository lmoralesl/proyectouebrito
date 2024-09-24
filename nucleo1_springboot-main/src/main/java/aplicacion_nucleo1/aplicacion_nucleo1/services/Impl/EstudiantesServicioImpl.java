package aplicacion_nucleo1.aplicacion_nucleo1.servicio.Impl;


import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Estudiantes;
import aplicacion_nucleo1.aplicacion_nucleo1.repositorio.EstudiantesRepositorio;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.EstudiantesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiantesServicioImpl implements EstudiantesServicio {

    @Autowired
    private EstudiantesRepositorio   estudiantesRepositorio;

    @Override
    public List<Estudiantes> getAllEstudiantes() {
        return estudiantesRepositorio.findAll();
    }

    @Override
    public Estudiantes getEstudiantesById(Integer id) {
        return estudiantesRepositorio.findById(id).orElse(null);
    }

    @Override
    public Estudiantes saveOrUpdateEstudiantes(Estudiantes estudiantes) {
        return estudiantesRepositorio.save(estudiantes);
    }

    @Override
    public boolean deleteEstudiantes(Integer id) {
        if (estudiantesRepositorio.existsById(id)) {
            estudiantesRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}
