package cl.world.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.world.models.City;
import cl.world.models.Country;
import cl.world.models.Language;
import cl.world.services.AppService;


@RestController
@RequestMapping("/api")
public class ApiWorldController {
	
	@Autowired
	private AppService appService;
	
	@GetMapping("/allCountries")
	public List<Country> allCountries(){
		return appService.allCountry();
	}
	@GetMapping("/country/lang/{lang}")
	public List<Object[]> findCountriesLanguage(
			@PathVariable("lang") String lang
			){
		return appService.findCountriesLanguage(lang);
	}
	
	@GetMapping("/ejercicio/1A")
	public List<Object[]> findCountriesLanguage(){
		return appService.findCountriesLanguage("Slovene");
	}
	
	@GetMapping("/ejercicio/1B")
	public List<Object[]> findCountriesLanguageJPQL(){
		return appService.findCountriesLanguageJPQL("Slovene");
	}
	
	@GetMapping("/ejercicio/2A")
	public List<Object[]> findTotalCities(){
		return appService.findTotalCities();
	}
	
	@GetMapping("/ejercicio/2B")
	public List<Object[]> findTotalCitiesJPQL(){
		return appService.findTotalCitiesJPQL();
	}
	
	@GetMapping("/ejercicio/3A")
	public List<Object[]> findCitiesMexico(){
		return appService.findCitiesMexico("Mexico", 500000);
	}
	
	@GetMapping("/ejercicio/3B")
	public List<Object[]> findCitiesMexicoJPQL(){
		return appService.findCitiesMexicoJPQL("Mexico", 500000);
	}
	
	@GetMapping("/ejercicio/4A")
	public List<Object[]> findIdiomas(){
		return appService.findIdiomas(89);
	}
	
	@GetMapping("/ejercicio/4B")
	public List<Object[]> findIdiomasJPQL(){
		return appService.findIdiomasJPQL(89.0);
	}
	
	@GetMapping("/ejercicio/5A")
	public List<Object[]> findArea(){
		return appService.findArea(501, 100000);
	}
	
	@GetMapping("/ejercicio/5C")
	public List<Country> findAreaPop(){
		return appService.findAreaPop(501.0, 100000);
	}
	
	@GetMapping("/ejercicio/6C")
	public List<Country> findMonarchy(){
		return appService.findMonarchy("Constitutional Monarchy", 75.0,200.0);
	}
    
	@GetMapping("/ejercicio/7A")
	public List<Object[]> findCityA(){
		return appService.findArg("Argentina", "Buenos Aires", 500000);
	}
	
	@GetMapping("/ejercicio/7B")
	public List<Object[]> findCityAJSQL(){
		return appService.findArgJSQL("Argentina", "Buenos Aires", 500000);
	}
	
	@GetMapping("/ejercicio/8A")
	public List<Object[]> findNumC(){
		return appService.findNumCountries();
	}
	
	@GetMapping("/ejercicio/8B")
	public List<Object[]> findNumCJSQL(){
		return appService.findNumCountriesJSQL();
	}
}


