package aplicacion_nucleo1.aplicacion_nucleo1.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_estudiantes")

public class Estudiantes  implements Serializable {

    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estudiante;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String fechaNacimientoº;

}