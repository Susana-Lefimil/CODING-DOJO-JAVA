package cl.inacap.exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import cl.inacap.exam.models.Rating;

public interface RatingRepo extends CrudRepository<Rating, Long> {

		List<Rating> findAll();
		
		@Query(value= "SELECT r.rating \r\n" + 
				"FROM examen_final.ratings r  join examen_final.shows s on r.show_id= s.id\r\n" + 
				"WHERE s.id= id=?1 \r\n" + 
				"order By r.rating Asc;\r\n" + 
				"SELECT * FROM examen_final.ratings; ",  nativeQuery=true)
		   List<Object[]> sort(Long id);
		
}
