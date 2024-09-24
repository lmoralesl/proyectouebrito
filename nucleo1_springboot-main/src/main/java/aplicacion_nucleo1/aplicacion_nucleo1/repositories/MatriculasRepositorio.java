package aplicacion_nucleo1.aplicacion_nucleo1.repositorio;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Matriculas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculasRepositorio  extends JpaRepository<Matriculas,Integer> {
}
