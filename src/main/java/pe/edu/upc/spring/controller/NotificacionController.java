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
import pe.edu.upc.spring.model.Notificacion;
import pe.edu.upc.spring.model.Reporte;
import pe.edu.upc.spring.service.IAutoridadService;
import pe.edu.upc.spring.service.IReporteService;
import pe.edu.upc.spring.service.INotificacionService;

@Controller
@RequestMapping("/notificacion")

public class NotificacionController {


	@Autowired
	private INotificacionService nService;

	@Autowired
	private IReporteService rService;	
	
	@Autowired
	private IAutoridadService aService;	

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; // "bienvenido" es una pagina del frontEnd, pagina de Inicio
	}

	@RequestMapping("/")
	public String irPaginaListadoReportes(Map<String, Object> model) {
		model.put("listaNotificaciones", nService.listar());
		return "listNotificacion"; // 
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaAutoridades", aService.listar());
		model.addAttribute("listaReportes", rService.listar());
		model.addAttribute("reporte", new Reporte());
		model.addAttribute("autoridad", new Autoridad());
		model.addAttribute("notificacion", new Notificacion());
		
		return "notificacion"; 
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Notificacion objNotificacion, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
			{
				model.addAttribute("listaAutoridades", aService.listar());
				model.addAttribute("listaReportes", rService.listar());			
				return "notificacion";
			}
		else {
			boolean flag = nService.grabar(objNotificacion);
			if (flag)
				return "redirect:/notificacion/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un rochezaso, LUZ ROJA");
				return "redirect:/notificacion/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Notificacion> objNotificacion = nService.listarId(id);
		if (objNotificacion == null) 
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrio un problema");
			return "redirect:/notificacion/listar";
		}
		else 
		{
			
			model.addAttribute("listaReportes", rService.listar());						
			if (objNotificacion.isPresent())
				objNotificacion.ifPresent(o -> model.addAttribute("notificacion", o)); //o: es el objpet
			return "notificacion";
		}
	}	

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {

			if (id!=null && id>0) {
				nService.eliminar(id);
				model.put("listaNotificaciones", nService.listar());
			}
		}

		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaNotificaciones", nService.listar());
		}
		return "listNotificacion";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaNotificaciones", nService.listar());
		return "listNotificacion";
	}

	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Notificacion notificacion ) 
	throws ParseException
	{
		nService.listarId(notificacion.getCNotificacion());
		return "listNotificacion";
	}	

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("notificacion", new Reporte());
		return "buscar";
	}	

	
	
}