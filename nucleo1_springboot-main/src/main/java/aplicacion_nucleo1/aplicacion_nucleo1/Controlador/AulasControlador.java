package aplicacion_nucleo1.aplicacion_nucleo1.controlador;


import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Aulas;
import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Cursos;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.AulasServicio;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.CursosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aulas")
public class AulasControlador {

    @Autowired
    private AulasServicio aulasServicio;

    @Autowired
    private CursosServicio cursosServicio;

    // Listar todas las aulas
    @GetMapping
    public String listAulas(Model model) {
        List<Aulas> aulas = aulasServicio.getAllAulas();
        model.addAttribute("aulas", aulas);
        return "aulas/index"; // Página HTML para listar aulas
    }

    // Mostrar el formulario para crear una nueva aula
    @GetMapping("/new")
    public String showNewForm(Model model) {
        List<Cursos> cursos = cursosServicio.getAllCursos();
        model.addAttribute("aulas", new Aulas());
        model.addAttribute("cursos", cursos); // Enviar lista de cursos al formulario
        return "aulas/form"; // Página HTML para el formulario de crear/editar
    }

    // Guardar o actualizar una aula
    @PostMapping
    public String saveAulas(@ModelAttribute("aulas") Aulas aulas) {
        aulasServicio.saveOrUpdateAulas(aulas);
        return "redirect:/aulas"; // Redirige a la lista de aulas después de guardar
    }

    // Mostrar el formulario para editar una aula existente
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Aulas aulas = aulasServicio.getAulasById(id);
        if (aulas != null) {
            List<Cursos> cursos = cursosServicio.getAllCursos();
            model.addAttribute("aulas", aulas);
            model.addAttribute("cursos", cursos); // Enviar lista de cursos al formulario
            return "aulas/form";
        } else {
            return "redirect:/aulas"; // Si no existe, redirige a la lista
        }
    }

    // Eliminar una aula
    @GetMapping("/delete/{id}")
    public String deleteAulas(@PathVariable("id") Integer id) {
        aulasServicio.deleteAulas(id);
        return "redirect:/aulas";
    }
}
