package cl.inacap.exam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.inacap.exam.models.User;
import cl.inacap.exam.services.UserService;
import cl.inacap.exam.validators.UserValidator;



@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
    
	
	@RequestMapping("/")
	public String login(@ModelAttribute("user") User user) {
		return "index.jsp";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes ra) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		if (null != userService.findByEmail(user.getEmail())) {
	        ra.addFlashAttribute("error", "User already exist");
	        return "redirect:/";
		}
		User u = userService.registerUser(user);
		session.setAttribute("user", u);
		return "redirect:/shows";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session,  RedirectAttributes ra) {
		if (userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("user", user);
			return "redirect:/shows";
		}
		
        ra.addFlashAttribute("error", "Invalid credentials");
		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// invalidar la sesión
		// redireccionar a la página de inicio de sesión.
		session.invalidate();
		return "redirect:/";
	}

}
