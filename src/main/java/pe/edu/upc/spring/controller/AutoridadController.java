package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Autoridad;
import pe.edu.upc.spring.service.IAutoridadService;

@Controller 	
@RequestMapping("/autoridad") //que atienda el controlador /race  (cuando hay muchos controladores), pero este no muestra nada, tiene q ir a bienvenido
public class AutoridadController {
	@Autowired
	private IAutoridadService aService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPremios(Map<String, Object> model) {
		model.put("listaAutoridades", aService.listar());
		return "listAutoridad"; // "listRace" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("autoridad", new Autoridad());
		return "autoridad"; // "race" es una pagina del frontEnd para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Autoridad objAutoridad, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "autoridad";
		else {
			boolean flag = aService.grabar(objAutoridad);
			if (flag)
				return "redirect:/autoridad/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un problema");
				return "redirect:/autoridad/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Autoridad> objAutoridad = aService.listarId(id);
		if (objAutoridad == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un problema");
			return "redirect:/autoridad/listar";
		}
		else {
			model.addAttribute("autoridad",objAutoridad);
			return "autoridad";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				aService.eliminar(id);
				model.put("listaAutoridades", aService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaAutoridades", aService.listar());
		}
		return "listAutoridad";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaAutoridades", aService.listar());
		return "listAutoridad";
	}
	
}
