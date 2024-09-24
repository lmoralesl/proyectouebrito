package aplicacion_nucleo1.aplicacion_nucleo1.repositorio;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Profesores;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesoresRepositorio extends JpaRepository<Profesores,Integer> {
}
