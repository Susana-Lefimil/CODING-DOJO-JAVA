package cl.inacap.lookify.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import cl.inacap.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long> {
	//Este método recupera todos los libros de la base de datos
    List<Lookify> findAll();
    
    List<Lookify> findByArtistContaining(String artist);


	List<Lookify> findTop10ByOrderByRating();   
}
