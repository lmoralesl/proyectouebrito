package aplicacion_nucleo1.aplicacion_nucleo1.servicio;



import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Estudiantes;

import java.util.List;

public interface EstudiantesServicio {
    List<Estudiantes> getAllEstudiantes();
    Estudiantes getEstudiantesById(Integer id);
    Estudiantes saveOrUpdateEstudiantes(Estudiantes estudiantes);
    boolean deleteEstudiantes(Integer id);
}
