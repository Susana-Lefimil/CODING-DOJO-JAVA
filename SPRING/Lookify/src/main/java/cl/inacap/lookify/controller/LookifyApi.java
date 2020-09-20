package cl.inacap.lookify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.inacap.lookify.Service.LookifyService;
import cl.inacap.lookify.models.Lookify;

@RestController
public class LookifyApi {
	
	@Autowired
	private LookifyService lookifyService;

	@RequestMapping("api/artist/{artist}")
	public List<Lookify> findArtist(@PathVariable("artist") String artist){
		return lookifyService.findArtist(artist);
	}
}
