package aplicacion_nucleo1.aplicacion_nucleo1.modelo;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name="tbl_aulas")

public class Aulas implements Serializable {
    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_aula;
    private String numero;
    private int capacidad;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Cursos cursos;
}