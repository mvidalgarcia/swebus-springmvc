package impl.miw.presentation.login;

import impl.miw.business.usermanager.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.model.User;

@Controller
public class LoginController {

	@Autowired
	private UserManager userManager;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signInGet(Model model, @ModelAttribute("user") User user, BindingResult result, HttpServletRequest request) {
		System.out.println("Entrando en Sign in");
		/* Guardamos la página de la que se proviene en sessión para volver a ella 
		 * una vez se complete la identificación */
		String referrer = request.getHeader("Referer");
	    request.getSession().setAttribute("url_prior_login", referrer);
		return "signin";
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String signInPost(Model model, @Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		//Verificar si existe ese usuario en el sistema.
		try {
			if(!userManager.isUser(user)){
				result.reject("signin.error");
				return "signin";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "signin";
		}
		// Crear objeto de sesión del usuario para mostrarlo en la cabecera
		session.setAttribute("sessionUser", user.getEmail());
		System.out.println("[LoginController] Usuario identificado en el sistema");
		String referer = (String) session.getAttribute("url_prior_login");
	    return "redirect:"+ referer;
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUpGet(Model model, @ModelAttribute("user") User user, BindingResult result) {
		System.out.println("[LoginController] Entrando en Sign up");
		return "signup";

	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUpPost(Model model, @Valid @ModelAttribute("user") User user, BindingResult result) {
		if ( result.hasErrors())
		{
			return "signup";
		}
		try {
			System.out.println("[LoginController] Intentando registrar usuario: "+ user);
			this.userManager.newUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("[LoginController] Usuario registrado");
		return "redirect:";

	}

}
