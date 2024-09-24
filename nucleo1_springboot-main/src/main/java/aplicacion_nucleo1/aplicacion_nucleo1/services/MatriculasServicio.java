package aplicacion_nucleo1.aplicacion_nucleo1.servicio;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Cursos;
import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Estudiantes;
import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Matriculas;


import java.util.List;

public interface MatriculasServicio {
    List<Matriculas> getAllMatriculas();
    List<Cursos> getAllCursos();
    List<Estudiantes> getAllEstudiantes();
    Matriculas getMatriculasById(Integer id);
    Matriculas saveOrUpdateMatriculas(Matriculas matriculas);
    boolean deleteMatriculas(Integer id);
}
