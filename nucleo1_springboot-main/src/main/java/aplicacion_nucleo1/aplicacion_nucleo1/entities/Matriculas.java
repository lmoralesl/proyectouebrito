package aplicacion_nucleo1.aplicacion_nucleo1.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_matriculas")

public class Matriculas implements Serializable {
    private  static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_matricula;
    private String fechaMatricula;
    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiantes estudiantes;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Cursos cursos;
}