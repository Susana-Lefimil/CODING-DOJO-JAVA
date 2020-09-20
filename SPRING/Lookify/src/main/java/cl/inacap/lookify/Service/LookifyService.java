package cl.inacap.lookify.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.inacap.lookify.Repository.LookifyRepository;
import cl.inacap.lookify.models.Lookify;



@Service
public class LookifyService {
	private final LookifyRepository  lookifyRepository;

	public LookifyService (LookifyRepository  lookifyRepository) {

		this.lookifyRepository=lookifyRepository;

	}
	public List<Lookify> allSong() {
		return lookifyRepository.findAll();
	}

	public Lookify findSong(Long id) {
		Optional<Lookify> song=lookifyRepository.findById(id);
		if (song.isPresent()) {

			return song.get();
		}
		return null;
	}
	
	public List <Lookify> findArtist(String artist ) {
		
		return lookifyRepository.findByArtistContaining(artist);
	
	}

     public List <Lookify> findTopSong() {
		
		return lookifyRepository.findTop10ByOrderByRating();
	
	}
	
	public Lookify addSong(Lookify cancion) {
		return lookifyRepository.save(cancion);
	}

	public void delete(Long id) {
		lookifyRepository.deleteById(id);
	}
	
}
