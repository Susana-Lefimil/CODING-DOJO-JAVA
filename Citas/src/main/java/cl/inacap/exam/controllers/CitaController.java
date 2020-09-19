package cl.inacap.exam.controllers;




import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.inacap.exam.models.Cita;

import cl.inacap.exam.models.User;
import cl.inacap.exam.service.CitaService;


@Controller
@RequestMapping("/appointments")
public class CitaController {

	@Autowired
	private CitaService citaService;
	
	
	
	
	@GetMapping("/add")
	public String createApp(@ModelAttribute("cita") Cita cita, Model m, HttpSession s) {

		return "formDate.jsp";
	}
	
	@PostMapping("/add")
	public String saveApp(@Valid@ModelAttribute("cita") Cita cita,
			BindingResult r, HttpSession s) {
           
		if(r.hasErrors()) {
			return "formDate.jsp";
			
		}
		
		User u= (User) s.getAttribute("user");
		if(u==null) {
			return "redirect:/";
		
		}
		
		cita.setUser(u);
		citaService.saveCita(cita);
		return "redirect:/appointments";
		
	}
	
	@GetMapping("")
	public String listApp(@ModelAttribute("cita") Cita cita, Model m, HttpSession s
			) {
    
		
		
		User u=(User) s.getAttribute("user");
		
		if(u==null) {
			return "redirect:/";
		}
		
		Date today =new Date();
		m.addAttribute("today", today);
		
		m.addAttribute("citas", citaService.findByUser(u));
		
    
		return "listApp.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String editForm(@ModelAttribute("cita") Cita cita, 
							Errors er,
			               @PathVariable("id") Long idCita,
			               Model m, HttpSession s) {
		User user=(User) s.getAttribute("user");
		if(user==null) {
			return "redirect:/appointments";
		}
		
		Cita i= citaService.findById(idCita);
		
		/** 
		 * Se compara el id de user de la idea con el id del user
		 */
		if(i==null || i.getUser().getId() != user.getId()) {
			return "redirect:/";
		}
		
		
		m.addAttribute("cita", i);
		return "edit.jsp";
	}
	
	/**
	 * Metodo put para actualizar una idea
	 * @param idea ModelAttribute, es valido
	 * @param er   donde se almacenan los errores de validacion
	 * @param idIdea   identificador de la idea
	 * @param m model
	 * @param s session
	 * @param redic Utilizado para enviar info en la redireccion
	 * @return
	 */
	
	@PostMapping("/{id}/edit")
	public String updateForm(@ModelAttribute("cita")@Valid Cita cita, 
							Errors er,
			               @PathVariable("id") Long idCita,
			               Model m, HttpSession s,
			               RedirectAttributes redic) {
		User user=(User) s.getAttribute("user");
		if(user==null) {
			return "redirect:/";
		}
		/**
		 * Si se detectan errores, agregamos la cita y los errores a redirect
		 * attributes para redireccionar a un GET de error
		 */
		
		if(er.getErrorCount()>0) {
			redic.addFlashAttribute("cita", cita);
			redic.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "idea" , er);
			return "redirect:/ideas/" + idCita +"/error";
			
		}
		Cita i= citaService.findById(idCita);
		i.setTask(cita.getTask());
		i.setDate(cita.getDate());
		citaService.saveCita(i);
		return "redirect:/appointments";
	}
	
	/**
	 * Muestra errores de validacion en la pagina de error
	 * @return
	 */
	
	@GetMapping("/{id}/error")
	public String inputEditError() {
		/*
		 * Aqui se carga los redirectAttributes enviados y son enviados a la pagina JSP
		 */
		return "edit.jsp";
	}
	
	/**
	 * Metodo para eliminar una idea utilizando el id
	 * @param id  identificador de la idea
	 * @param session  HttpSession inyectado
	 * @return    ubicacion para redireccionar
	 */
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long idCita, 
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		}
		
		//Idea i= this.ideaService.findByIdIdea(id);
	     //this.ideaService.dropIdeaLikes(id);
		
		this.citaService.delete(idCita);	
		return "redirect:/appointments";
	}
	
}
