package aplicacion_nucleo1.aplicacion_nucleo1.servicio;



import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Cursos;

import java.util.List;

public interface CursosServicio {
    List<Cursos> getAllCursos();
    Cursos getCursosById(Integer id);
    Cursos saveOrUpdateCursos(Cursos cursos);
    boolean deleteCursos(Integer id);
}
