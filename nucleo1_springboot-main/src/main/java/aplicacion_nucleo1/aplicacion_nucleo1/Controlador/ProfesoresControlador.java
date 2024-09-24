package aplicacion_nucleo1.aplicacion_nucleo1.controlador;

import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Aulas;
import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Profesores;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.AulasServicio;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.ProfesoresServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesores")
public class ProfesoresControlador {

    @Autowired
    private ProfesoresServicio profesoresServicio;

    @Autowired
    private AulasServicio aulasServicio;

    // Listar todos los profesores
    @GetMapping
    public String listProfesores(Model model) {
        List<Profesores> profesores = profesoresServicio.getAllProfesores();
        model.addAttribute("profesores", profesores);
        return "profesores/index"; // Página HTML para listar profesores
    }

    // Mostrar el formulario para crear un nuevo profesor
    @GetMapping("/new")
    public String showNewForm(Model model) {
        List<Aulas> aulas = aulasServicio.getAllAulas();
        model.addAttribute("profesores", new Profesores());
        model.addAttribute("aulas", aulas); // Enviar lista de aulas al formulario
        return "profesores/form"; // Página HTML para el formulario de crear/editar
    }

    // Guardar o actualizar un profesor
    @PostMapping
    public String saveProfesores(@ModelAttribute("profesores") Profesores profesores) {
        profesoresServicio.saveOrUpdateProfesores(profesores);
        return "redirect:/profesores"; // Redirige a la lista de profesores después de guardar
    }

    // Mostrar el formulario para editar un profesor existente
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Profesores profesores = profesoresServicio.getProfesoresById(id);
        if (profesores != null) {
            List<Aulas> aulas = aulasServicio.getAllAulas();
            model.addAttribute("profesores", profesores);
            model.addAttribute("aulas", aulas); // Enviar lista de aulas al formulario
            return "profesores/form";
        } else {
            return "redirect:/profesores"; // Si no existe, redirige a la lista
        }
    }

    // Eliminar un profesor
    @GetMapping("/delete/{id}")
    public String deleteProfesores(@PathVariable("id") Integer id) {
        profesoresServicio.deleteProfesores(id);
        return "redirect:/profesores";
    }
}
