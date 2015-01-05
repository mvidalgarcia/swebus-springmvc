package impl.miw.presentation.additionals;


import impl.miw.business.usermanager.UserManager;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.model.Reservation;

@Controller
@SessionAttributes("reservation")
public class AdditionalsController {
	
	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/showAdditionals", method = RequestMethod.GET)
	public String showAdditionalOptions(Model model, @ModelAttribute("reservation") Reservation reservation, BindingResult result) {
		System.out.println("[AdditionalsController - showAdditionalOptions] Entrando en Additional Options");
		return "showAdditionals";
	}
	
	@RequestMapping(value = "/showAdditionals", method = RequestMethod.POST)
	public String sumbmitAdditionalOptions(Model model, @ModelAttribute("reservation") Reservation reservation, BindingResult result, HttpSession session) throws Exception {
		String sessionUser = (String) session.getAttribute("sessionUser");
		System.out.println("[AdditionalsController - submitAdditionalOptions] Sesión de usuario: " + sessionUser);
		System.out.println("[AdditionalsController - submitAdditionalOptions] Estado de la reserva: " + reservation);
		if (sessionUser == null)
			return "redirect:signIn";
		else {
			// Una vez que sabemos que el usuario está identificado, guardar su ID en la reserva.
			reservation.setIdUser(userManager.findIdUserByEmail(sessionUser));
			return "redirect:payment";
		}

	}

}
