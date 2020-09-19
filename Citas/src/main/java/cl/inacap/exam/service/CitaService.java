package cl.inacap.exam.service;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.inacap.exam.models.Cita;
import cl.inacap.exam.models.User;
import cl.inacap.exam.repositories.CitaRepo;

@Service
public class CitaService {
	
	@Autowired
	public CitaRepo citaRepo;
     
	public List<Cita> findAll(){
		return citaRepo.findAll();
	}

	

	public void saveCita(@Valid Cita cita) {
		citaRepo.save(cita);
		
	}

	public List<Cita> findByUser(User u) {
		
		return citaRepo.findByUser(u);
	}



	public Cita findById(Long id) {
		Optional <Cita> opCita=citaRepo.findById(id);
		if(opCita.isPresent()) {
			return opCita.get();
			
		}else {
			
		}
		return null;
	}
	
	public void delete(Long id) {
		Cita cita=findById(id);
		if(cita==null) {
			return;
		}
		citaRepo.deleteById(id);
	}
	
	
}
