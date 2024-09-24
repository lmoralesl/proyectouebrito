package aplicacion_nucleo1.aplicacion_nucleo1.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_profesores")

public class Profesores  implements Serializable {

    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_profesor;
    private String nombre;
    private String apellido;
    private String email;
    private String especializacion;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aulas aulas;
}