package aplicacion_nucleo1.aplicacion_nucleo1.controlador;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Cursos;
import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Estudiantes;
import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Matriculas;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.CursosServicio;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.EstudiantesServicio;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.MatriculasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/matriculas")
public class MatriculasControlador {

    @Autowired
    private MatriculasServicio matriculasServicio;

    @Autowired
    private EstudiantesServicio estudiantesServicio;

    @Autowired
    private CursosServicio cursosServicio;

    // Listar todas las matrículas
    @GetMapping
    public String listMatriculas(Model model) {
        List<Matriculas> matriculas = matriculasServicio.getAllMatriculas();
        model.addAttribute("matriculas", matriculas);
        return "matriculas/index"; // Página HTML para listar matrículas
    }

    // Mostrar el formulario para crear una nueva matrícula
    @GetMapping("/new")
    public String showNewForm(Model model) {
        List<Estudiantes> estudiantes = estudiantesServicio.getAllEstudiantes();
            List<Cursos> cursos = cursosServicio.getAllCursos();
            model.addAttribute("matriculas", new Matriculas());
        model.addAttribute("estudiantes", estudiantes); // Enviar lista de estudiantes al formulario
        model.addAttribute("cursos", cursos); // Enviar lista de cursos al formulario
        return "matriculas/form"; // Página HTML para el formulario de crear/editar
    }

    // Guardar o actualizar una matrícula
    @PostMapping
    public String saveMatriculas(@ModelAttribute("matriculas") Matriculas matriculas, Model model) {
        // Obtener el estudiante y el curso por su ID y asignarlos al objeto Matriculas
        Estudiantes estudiante = estudiantesServicio.getEstudiantesById(matriculas.getEstudiantes().getId_estudiante());
        Cursos curso = cursosServicio.getCursosById(matriculas.getCursos().getId_curso());

        matriculas.setEstudiantes(estudiante);
        matriculas.setCursos(curso);

        matriculasServicio.saveOrUpdateMatriculas(matriculas);
        return "redirect:/matriculas";
    }

    // Mostrar el formulario para editar una matrícula existente
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Matriculas matriculas = matriculasServicio.getMatriculasById(id);
        if (matriculas != null) {
            List<Estudiantes> estudiantes = estudiantesServicio.getAllEstudiantes();
            List<Cursos> cursos = cursosServicio.getAllCursos();
            model.addAttribute("matriculas", matriculas);
            model.addAttribute("estudiantes", estudiantes); // Enviar lista de estudiantes al formulario
            model.addAttribute("cursos", cursos); // Enviar lista de cursos al formulario
            return "matriculas/form"; // Página HTML para el formulario de crear/editar
        } else {
            return "redirect:/matriculas"; // Si no existe, redirige a la lista
        }
    }

    // Eliminar una matrícula
    @GetMapping("/delete/{id}")
    public String deleteMatriculas(@PathVariable("id") Integer id) {
        matriculasServicio.deleteMatriculas(id);
        return "redirect:/matriculas";
    }
}
