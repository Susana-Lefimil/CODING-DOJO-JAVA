package cl.inacap.lookify.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import cl.inacap.lookify.Service.LookifyService;
import cl.inacap.lookify.models.Lookify;

@Controller
public class LookifyController {

	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService=lookifyService;
		
	}
	
	@RequestMapping("/")
	public String index() {
		return "/pages/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard( Model m) {
		List<Lookify> cancion=lookifyService.allSong();
		m.addAttribute("canciones", cancion);	
		return "pages/dashboard.jsp";
	}
	
	@RequestMapping("/search")
	public String search( @RequestParam("artist") String artist, Model m) {
		m.addAttribute("artista", lookifyService.findArtist(artist));
		m.addAttribute("artist", artist);
		return "pages/search.jsp";
	}
	
	@RequestMapping("/search/top")
	public String top (Model m) {
		m.addAttribute("top", lookifyService.findTopSong());
		return "pages/top.jsp";
	}
	
	@RequestMapping("/search/{id}")
	public String show( @PathVariable("id") Long id, Model m) {
		m.addAttribute("song", lookifyService.findSong(id));
		return "pages/show.jsp";
	}
	
	@RequestMapping("/show/{id}")
	public String delete( @PathVariable("id") Long id, Model m) {
		lookifyService.delete(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/songs/new")
	public String newSong( @ModelAttribute("newSong") Lookify lok, Model m) {
		return "pages/new.jsp";
	}
	
	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String song(@Valid @ModelAttribute("newSong") Lookify lok, BindingResult result, Model m) {
		
		if(result.hasErrors()) {
			return "pages/new.jsp";
		
		}else {
		
		lookifyService.addSong(lok);
		return "redirect:/dashboard";
	  }
	
	}
}
