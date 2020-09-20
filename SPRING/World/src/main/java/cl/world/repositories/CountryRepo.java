package cl.world.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.world.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long> {

	List<Country> findAll();
	// Consulta 1
	@Query(
			  value="SELECT \n" + 
					"	c.name,\n" + 
					"	l.language,\n" + 
					"    l.percentage\n" + 
					"FROM \n" + 
					"	world.languages l JOIN world.countries c \n" + 
					"	ON l.country_id = c.id  \n" + 
					"WHERE \n" + 
					"	language = ?1 \n"+
					"ORDER BY percentage DESC ;", nativeQuery = true)
			List<Object[]> findCountriesLanguage(String lang);
			
			
			@Query( "SELECT c.name, l.language, l.percentage "+
					"FROM Country c JOIN c.languages l "+
					"WHERE l.language = ?1 ORDER BY l.percentage DESC")
			List<Object[]> findCountriesLanguageJPQL(String lang);
	
	// Consulta 2		
	@Query(value="SELECT countries.name AS Country, count(cities.id) AS City\n" + 
			"FROM countries\n" + 
			"	 JOIN cities ON countries.id = cities.country_id\n" + 
			"     group by  countries.name\n" + 
			"     ORDER BY City DESC;", nativeQuery = true)
	List<Object[]>findTotalCities();
	
	
	@Query("SELECT c.name, count(ct.id) AS qty "
			+ "FROM Country c JOIN c.cities ct "
			+ "GROUP BY c.name ORDER BY qty DESC ")
	List<Object[]>findTotalCitiesJPQL();
	
	
	// Consulta 3
	@Query (value="SELECT cities.name AS City, countries.population AS Population\n" + 
			"FROM countries\n" + 
			"JOIN cities ON countries.id = cities.country_id\n" + 
			"WHERE countries.name = ?1 AND countries.population > ?2\n" + 
			"ORDER BY population DESC;", nativeQuery = true)
	List<Object[]>findCitiesMexico(String name, Integer p );
	
	
	@Query("SELECT ct.name, ct.population "
			+ "FROM Country c JOIN c.cities ct "
			+ "WHERE ct.population > ?2 AND c.name = ?1 "
			+ "ORDER BY ct.population DESC ")
	List<Object[]>findCitiesMexicoJPQL(String name, Integer p );
	
	// Consulta 4
	@Query(value="SELECT countries.name AS Country, languages.language AS Languages, languages.percentage AS Percentaje\n" + 
			"FROM countries\n" + 
			"JOIN languages ON countries.id = languages.country_id\n " + 
			"WHERE languages.percentage > ?1 \n " + 
			"ORDER BY percentage DESC;", nativeQuery = true)
	List<Object[]>findIdiomas(Integer p);
	
	@Query("SELECT c.name, l.language, l.percentage "
			+ "FROM Country c "
			+ "JOIN c.languages l "
			+ "WHERE l.percentage > ?1 "
			+ "ORDER BY l.percentage DESC"
			)
	List<Object[]>findIdiomasJPQL(Double p);
	
	// Consulta 5
	@Query(value="SELECT countries.name, countries.surface_area, countries.population\n" + 
			"FROM countries\n" + 
			"WHERE countries.surface_area < ?1 "
			+ "AND countries.population > ?2 ; ", nativeQuery = true)
	List<Object[]>findArea(Integer a, Integer p);
	
	List<Country> findBySurfaceAreaLessThanAndPopulationGreaterThan(Double a, Integer p);
	
	//Consulta 6 JPA

	List<Country> findByGovernmentFormAndLifeExpectancyGreaterThanAndSurfaceAreaGreaterThan(String gob, Double life, Double area);
	
	//Consulta 7
	@Query(value="SELECT countries.name AS Country, cities.name AS City, cities.district AS District, cities.population AS Population\n" + 
				"FROM countries\n" + 
				"JOIN cities ON countries.id = cities.country_id\n" + 
				"WHERE countries.name = ?1 AND cities.district = ?2 AND cities.population > ?3 ; ",nativeQuery = true)
	List<Object[]>findCitiesArgentina(String p, String d, Integer po);
	
	
	@Query("SELECT c.name, ct.name, ct.district, ct.population "
			+ "FROM Country c "
			+ "JOIN c.cities ct "
			+ "WHERE c.name = ?1 AND ct.district = ?2 AND ct.population > ?3 ")
	List<Object[]>findCitiesArgentinaJSQL(String p, String d, Integer po);
	
	
	//Consulta 8

	@Query(value="SELECT countries.region AS Name_Region, count(countries.id) AS Number_Countries\n" + 
			"FROM countries\n" + 
			"GROUP BY countries.region\n" + 
			"ORDER BY count(countries.id) desc;", nativeQuery = true)
	List<Object[]>findNumeroCountriesByRegion();
	
	@Query ("SELECT c.region, count(c.id) "
			+ "FROM Country c "
			+ "GROUP BY c.region "
			+ "ORDER BY count(c.id) DESC ")
	List<Object[]>findNumeroCountriesByRegionJSQL();
	
}
