package pe.edu.upc.spring.controller;

import java.util.List;
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

import pe.edu.upc.spring.model.Distrito;
import pe.edu.upc.spring.service.IDistritoService;

@Controller 	
@RequestMapping("/distrito") //que atienda el controlador /race  (cuando hay muchos controladores), pero este no muestra nada, tiene q ir a bienvenido
public class DistritoController {
	@Autowired
	private IDistritoService dService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}
	
	@RequestMapping("/")
	public String irPaginaListadoDistritos(Map<String, Object> model) {
		model.put("listaDistritos", dService.listar());
		return "listDistrito"; // "listRace" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("distrito", new Distrito());
		return "distrito"; // "race" es una pagina del frontEnd para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Distrito objDistrito, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			return "distrito";
		else {
			/*boolean flag = dService.grabar(objDistrito);*/
			int rpta = dService.grabar(objDistrito);
			if(rpta > 0) {
				model.addAttribute("mensaje", "Este distrio ya existe");
				return "distrito/listar";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				return "redirect:/distrito/listar";
			}
			/*if (flag)
				return "redirect:/distrito/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un problema");
				return "redirect:/distrito/irRegistrar";
			}*/
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Distrito> objDistrito = dService.listarId(id);
		if (objDistrito == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un problema");
			return "redirect:/distrito/listar";
		}
		else {
			model.addAttribute("distrito",objDistrito);
			return "distrito";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				dService.eliminar(id);
				model.put("listaDistritos", dService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaDistritos", dService.listar());
		}
		return "listDistrito";
	}
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaDistritos", dService.listar());
		return "listDistrito";
	}
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("distrito", new Distrito());
		return "buscardistrito";
	}	

	@RequestMapping("/buscar")
	
	public String buscar(Map<String, Object> model, @ModelAttribute Distrito distrito ) 
	throws ParseException
	{
		List<Distrito> listaDistritos;
		
		distrito.setNDistrito(distrito.getNDistrito()); //capturo lo que dijite en la cajita de texto
		
		listaDistritos = dService.buscarDistrito(distrito.getNDistrito());
		
		
		if (listaDistritos.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaDistritos", listaDistritos);
		
		return "buscardistrito";
	}	
	
	
}
