package cl.world.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.world.models.Country;
import cl.world.repositories.CityRepo;
import cl.world.repositories.CountryRepo;
import cl.world.repositories.LanguageRepo;

@Service

public class AppService {
	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private CountryRepo countryRepo;
	
	@Autowired
	private LanguageRepo languageRepo;
	

	public List<Country> allCountry() {
		return countryRepo.findAll();
	}
	public List<Object[]> findCountriesLanguage(String lang){
		return countryRepo.findCountriesLanguage(lang);
	}
	
	public List<Object[]> findCountriesLanguageJPQL(String lang){
		return countryRepo.findCountriesLanguageJPQL(lang);
	}
	
	public List<Object[]> findTotalCities(){
		return countryRepo.findTotalCities();
	}
	
	public List<Object[]> findTotalCitiesJPQL(){
		return countryRepo.findTotalCitiesJPQL();
	}
	public List<Object[]>findCitiesMexico(String name, Integer p){
		return countryRepo.findCitiesMexico(name, p);
	}
	public List<Object[]>findCitiesMexicoJPQL(String name, Integer p){
		return countryRepo.findCitiesMexicoJPQL(name, p);
	}
	public List<Object[]>findIdiomas(Integer p){
		return countryRepo.findIdiomas(p);
	}
	public List<Object[]>findIdiomasJPQL(Double p){
		return countryRepo.findIdiomasJPQL(p);
	}
	public List<Object[]>findArea(Integer a, Integer p){
		return countryRepo.findArea(a, p);
	}
	public List<Country>findAreaPop(Double a, Integer p){
		return countryRepo.findBySurfaceAreaLessThanAndPopulationGreaterThan(a, p);
	}
	public List<Country>findMonarchy(String gob, Double life, Double area){
		return countryRepo.findByGovernmentFormAndLifeExpectancyGreaterThanAndSurfaceAreaGreaterThan(gob, life, area);
	}
	
	public List <Object[]> findArg(String p, String d, Integer po){
	    return countryRepo.findCitiesArgentina(p, d, po);
	}
	public List <Object[]> findArgJSQL(String p, String d, Integer po){
	    return countryRepo.findCitiesArgentinaJSQL(p, d, po);
	}
	public List <Object[]> findNumCountries(){
		return countryRepo.findNumeroCountriesByRegion();
	}
	public List <Object[]> findNumCountriesJSQL(){
		return countryRepo.findNumeroCountriesByRegionJSQL();
	}
}
