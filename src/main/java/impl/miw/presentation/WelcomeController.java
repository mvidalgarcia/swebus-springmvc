package impl.miw.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	/*
	 * Setting / as request mapping url we are setting the default controller
	 * for the application.
	 */
	@RequestMapping("/")
	public String welcome(Model model, HttpSession session) {
		System.out.println("Ejecutando controlador Welcome");
		String sessionUser = (String) session.getAttribute("sessionUser");
		model.addAttribute("sessionUser", sessionUser);
		System.out.println("Sesión: " + sessionUser);
		return "index";
	}	
	
}
