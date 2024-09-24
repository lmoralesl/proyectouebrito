package aplicacion_nucleo1.aplicacion_nucleo1.servicio;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Aulas;


import java.util.List;

public interface AulasServicio {
    List<Aulas> getAllAulas();
    List<Aulas> getAllCursos(); // Si es necesario, implementa la lógica específica
    Aulas getAulasById(Integer id);
    Aulas saveOrUpdateAulas(Aulas aulas);
    boolean deleteAulas(Integer id);
}
