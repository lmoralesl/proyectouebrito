package aplicacion_nucleo1.aplicacion_nucleo1.servicio.Impl;



import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Cursos;
import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Estudiantes;
import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Matriculas;
import aplicacion_nucleo1.aplicacion_nucleo1.repositorio.MatriculasRepositorio;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.MatriculasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculasServicioImpl  implements MatriculasServicio {

    @Autowired
    private MatriculasRepositorio matriculasRepositorio;

    @Override
    public List<Matriculas> getAllMatriculas() {
        return matriculasRepositorio.findAll();
    }

    @Override
    public List<Cursos> getAllCursos() {
        return List.of();
    }

    @Override
    public List<Estudiantes> getAllEstudiantes() {
        return List.of();
    }

    @Override
    public Matriculas getMatriculasById(Integer id) {
        return matriculasRepositorio.findById(id).orElse(null);
    }

    @Override
    public Matriculas saveOrUpdateMatriculas(Matriculas matriculas) {
        return matriculasRepositorio.save(matriculas);
    }

    @Override
    public boolean deleteMatriculas(Integer id) {
        if (matriculasRepositorio.existsById(id)) {
            matriculasRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}
