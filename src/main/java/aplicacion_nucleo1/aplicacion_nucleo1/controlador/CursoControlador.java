package aplicacion_nucleo1.aplicacion_nucleo1.controlador;


import aplicacion_nucleo1.aplicacion_nucleo1.modelo.Cursos;
import aplicacion_nucleo1.aplicacion_nucleo1.servicio.CursosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoControlador {

    @Autowired
    private CursosServicio cursosServicio;

    @GetMapping
    public String listCursos(Model model) {
        List<Cursos> cursos = cursosServicio.getAllCursos();
        model.addAttribute("cursos", cursos);
        return "cursos/index"; // Página HTML para listar cursos
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("cursos", new Cursos());
        return "cursos/form"; // Página HTML para el formulario de crear/editar
    }

    @PostMapping
    public String saveCursos(@ModelAttribute("cursos") Cursos cursos) {
        cursosServicio.saveOrUpdateCursos(cursos);
        return "redirect:/cursos";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Cursos cursos = cursosServicio.getCursosById(id);
        if (cursos != null) {
            model.addAttribute("cursos", cursos);
            return "cursos/form";
        } else {
            return "redirect:/cursos"; // Si no existe, redirige a la lista
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCursos(@PathVariable("id") Integer id) {
        cursosServicio.deleteCursos(id);
        return "redirect:/cursos";
    }

}
