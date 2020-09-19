package cl.inacap.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.inacap.exam.models.Rating;
import cl.inacap.exam.models.Show;
import cl.inacap.exam.repositories.RatingRepo;
import cl.inacap.exam.repositories.ShowRepo;


@Service
public class ShowService {
	
	@Autowired
	private ShowRepo showRepo;
	
	@Autowired
	private RatingRepo ratingRepo;
	
	public Rating createR(Rating r) {
		return ratingRepo.save(r);
	}
	
	public List<Show> findAll(){
		return showRepo.findAll();
	}
	
	public Show saveShow(Show show) {
		return showRepo.save(show);
	}
	
	public Show findByShow(Long id) {
		Optional<Show> opShow=showRepo.findById(id);
		if(opShow.isPresent()) {
			return opShow.get();
		}
		return null;
		
	}

	public void dropShow(Long id) {
		showRepo.deleteById(id);
		
	}
	
	public List <Object[]> Sort(Long id){
		return ratingRepo.sort(id);
	}
	
	public Show findUserByTitle(String n) {
		return showRepo.findByName(n);

	}	
}
