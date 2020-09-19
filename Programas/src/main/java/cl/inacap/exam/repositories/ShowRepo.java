package cl.inacap.exam.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import cl.inacap.exam.models.Show;


public interface ShowRepo extends CrudRepository<Show, Long>{

	Show findByName(String string);

	List<Show> findAll();
	
}
