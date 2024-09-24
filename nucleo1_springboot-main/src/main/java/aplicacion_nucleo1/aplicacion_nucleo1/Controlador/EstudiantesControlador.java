package aplicacion_nucleo1.aplicacion_nucleo1.controlador;


import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Estudiantes;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.EstudiantesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudiantesControlador {

    @Autowired
    private EstudiantesServicio estudiantesServicio;

    @GetMapping
    public String listEstudiantes(Model model) {
        List<Estudiantes> estudiantes = estudiantesServicio.getAllEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiantes/index"; // Página HTML para listar estudiantes
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("estudiantes", new Estudiantes());
        return "estudiantes/form"; // Página HTML para el formulario de crear/editar
    }

    @PostMapping
    public String saveEstudiantes(@ModelAttribute("estudiantes") Estudiantes estudiantes) {
        estudiantesServicio.saveOrUpdateEstudiantes(estudiantes);
        return "redirect:/estudiantes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Estudiantes estudiantes = estudiantesServicio.getEstudiantesById(id);
        if (estudiantes != null) {
            model.addAttribute("estudiantes", estudiantes);
            return "estudiantes/form";
        } else {
            return "redirect:/cursos"; // Si no existe, redirige a la lista
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteEstudiantes(@PathVariable("id") Integer id) {
        estudiantesServicio.deleteEstudiantes(id);
        return "redirect:/estudiantes";
    }
}
