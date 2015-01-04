package impl.miw.presentation.additionals;


import javax.servlet.http.HttpSession;

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

	@RequestMapping(value = "/showAdditionals", method = RequestMethod.GET)
	public String showAdditionalOptions(Model model, @ModelAttribute("reservation") Reservation reservation, BindingResult result) {
		System.out.println("[AdditionalsController - Entrando en Additional Options");
		return "showAdditionals";
	}
	
	@RequestMapping(value = "/showAdditionals", method = RequestMethod.POST)
	public String sumbmitAdditionalOptions(Model model, @ModelAttribute("reservation") Reservation reservation, BindingResult result, HttpSession session) {
		String sessionUser = (String) session.getAttribute("sessionUser");
		System.out.println("[AdditionalsController - submitAdditionalOptions] Sesi�n de usuario: " + sessionUser);
		System.out.println("[AdditionalsController - submitAdditionalOptions] Estado de la reserva: " + reservation);
		if (sessionUser == null)
			return "redirect:signIn";
		else
			return "payment";

	}

}
