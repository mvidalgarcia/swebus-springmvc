package impl.miw.presentation.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn(Model model) {
		System.out.println("Entrando en Sign in");
		return "signin";

	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp(Model model) {
		System.out.println("Entrando en Sign up");
		return "signup";

	}

}
