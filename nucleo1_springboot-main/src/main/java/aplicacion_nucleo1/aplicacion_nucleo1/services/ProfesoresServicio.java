package aplicacion_nucleo1.aplicacion_nucleo1.servicio;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Aulas;
import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Profesores;


import java.util.List;

public interface ProfesoresServicio {
    List<Profesores> getAllProfesores();
    List<Aulas> getAllAulas();
    Profesores getProfesoresById(Integer id);
    Profesores saveOrUpdateProfesores(Profesores profesores);
    boolean deleteProfesores(Integer id);
}
