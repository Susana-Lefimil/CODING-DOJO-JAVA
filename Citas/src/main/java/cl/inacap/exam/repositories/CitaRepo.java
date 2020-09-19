package cl.inacap.exam.repositories;


import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.inacap.exam.models.Cita;

import cl.inacap.exam.models.User;

@Repository
public interface CitaRepo extends CrudRepository<Cita, Long>{
	
	List<Cita> findAll();
	

	
	List<Cita> findByUser(User user);
	
	
	

}
