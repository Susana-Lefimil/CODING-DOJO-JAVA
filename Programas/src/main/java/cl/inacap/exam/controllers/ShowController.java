package cl.inacap.exam.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import cl.inacap.exam.models.Rating;
import cl.inacap.exam.models.Show;
import cl.inacap.exam.models.User;
import cl.inacap.exam.services.ShowService;


@Controller
@RequestMapping("/shows")
public class ShowController {
	
	@Autowired
	private ShowService showService;
	
	
	
	@GetMapping("/new")
	public String createShow(@ModelAttribute("show") Show show,
							Model m,
							HttpSession s) {
		return "createShow.jsp";
	}
	
	@PostMapping("/new")
	public String saveShow(@Valid@ModelAttribute("show") Show show,
			               RedirectAttributes redirectAttributes,
			               Model m,
			               BindingResult r, 
			               HttpSession s) {
		if(r.hasErrors()) {
			return "createShow.jsp";
			
		}
		 User u=(User) s.getAttribute("user");
		 if(u==null) {
			 return "redirect:/";
		 }
		 
		 Show verif=showService.findUserByTitle(show.getName());
	    	if(verif!=null) {
	    		redirectAttributes.addFlashAttribute("mensaje", "Show ya existe");
	    		return "redirect:/shows/new";
			}
		 showService.saveShow(show);
		 return "redirect:/shows";
		 
		}
	@GetMapping ("")
	
	public String listShow(@ModelAttribute("show") Show show,
						 Model m,
						 HttpSession s) {
		 User u=(User) s.getAttribute("user");
		 if(u==null) {
			 return "redirect:/";
		 }
		 
		 m.addAttribute("shows", showService.findAll());
		 return "listShow.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String editForm(@ModelAttribute("show") Show show, 
							Errors er,
			               @PathVariable("id") Long idShow,
			               Model m, HttpSession s) {
		User u=(User) s.getAttribute("user");
		if(u==null) {
			return "redirect:/";
		}
		
		Show sh= showService.findByShow(idShow);	
		m.addAttribute("show", sh);
		return "edit.jsp";
	}
	
	
	@PostMapping("/{id}/edit")
	public String updateForm(@ModelAttribute("show")@Valid Show show, 
							Errors er,
			               @PathVariable("id") Long idShow,
			               Model m, HttpSession s,
			               RedirectAttributes redic) {
		User user=(User) s.getAttribute("user");
		if(user==null) {
			return "redirect:/";
		}
		
		if(er.getErrorCount()>0) {
			redic.addFlashAttribute("Show", show);
			redic.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "show" , er);
			return "redirect:/ideas/" + idShow +"/error";
			
		}
		
		Show sh= showService.findByShow(idShow);
		sh.setName(show.getName());
		sh.setNetwork(show.getNetwork());
		showService.saveShow(sh);
		return "redirect:/shows";
		
	}
	

	
	@GetMapping("/{id}/error")
	public String inputEditError() {
		
		return "edit.jsp";
	}
	
	@GetMapping("/{id}")
	public String showById(@ModelAttribute("rating") Rating rating, 
			               @PathVariable("id")Long id, 
			               Model m, HttpSession s) {
		User u=(User) s.getAttribute("user");
		
		if(u==null) {
			return "redirect:/shows";
		}
		Show sh = showService.findByShow(id);
		if (sh == null) {
			return "redirect:/shows";
		}
		
		m.addAttribute("user", u);
		m.addAttribute("show", sh);
		
		
		return "viewShow.jsp";
	}
	
	
	@PostMapping("/{id}/rating")
	public String saveRating(
			@Valid @ModelAttribute("rating") Rating rating,		
			 BindingResult result,
			@PathVariable("id") Long idShow, 
			Model m, HttpSession s){
		
		User user = (User) s.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		}
		
		Show sh = showService.findByShow(idShow);
		if (sh == null) {
			return "redirect:/shows";
		}
		m.addAttribute("show", sh);		
		if (result.hasErrors()) {
			return "redirect:/shows";
		}
		
		Rating r = new Rating();		
		r.setUser(user);
		r.setShow(sh);
		r.setRating(rating.getRating());
		
		showService.createR(r);
		return "redirect:/shows/"+idShow;
	}
	
	@DeleteMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id, 
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/";
		}
		
		this.showService.dropShow(id);	
		return "redirect:/shows";
	}
}
