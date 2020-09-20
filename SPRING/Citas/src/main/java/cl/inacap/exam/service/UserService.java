package cl.inacap.exam.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.inacap.exam.models.User;
import cl.inacap.exam.repositories.UserRepo;



@Service
public class UserService {

	@Autowired
	private UserRepo userRepository;

	// registrar el usuario y hacer Hash a su password
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPasswd(), BCrypt.gensalt());
		user.setPasswd(hashed);
		return userRepository.save(user);
	}

	// encontrar un usuario por su email
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	// encontrar un usuario por su id
	public User findUserById(Long id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			return u.get();
		}
		return null;
	}

	// autenticar usuario
	public boolean authenticateUser(String email, String password) {
		// primero encontrar el usuario por su email
		User user = userRepository.findByEmail(email);
		// si no lo podemos encontrar por su email, retornamos false
		if (user == null) {
			return false;
		}

		// si el password coincide devolvemos true, sino, devolvemos false
		if (BCrypt.checkpw(password, user.getPasswd())) {
			return true;
		}
		
		return false;	
	}

}
