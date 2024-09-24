package aplicacion_nucleo1.aplicacion_nucleo1.repositorio;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Estudiantes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantesRepositorio extends JpaRepository<Estudiantes,Integer> {
}
