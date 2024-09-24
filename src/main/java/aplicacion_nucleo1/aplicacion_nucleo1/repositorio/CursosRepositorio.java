package aplicacion_nucleo1.aplicacion_nucleo1.repositorio;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Cursos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosRepositorio  extends JpaRepository<Cursos, Integer> {
}
