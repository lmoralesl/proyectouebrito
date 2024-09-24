package aplicacion_nucleo1.aplicacion_nucleo1.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_cursos")

public class Cursos implements Serializable {

    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_curso;
    private String nombre;
    private String descripcion;
    private int creditos;

}