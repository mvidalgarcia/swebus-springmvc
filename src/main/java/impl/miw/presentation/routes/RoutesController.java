package impl.miw.presentation.routes;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
public class RoutesController {
	
	@RequestMapping(value = "/showRoutes", method = RequestMethod.GET)
	public String showRoutesTimes(Model model, @ModelAttribute("reservation") Reservation reservation, BindingResult result) {
		System.out.println("[RoutesController] Entrando en Show Routes");
		System.out.println("[RoutesController] Estado de la reserva: " + reservation);
		//Obtener precio de la ruta
		//Establecer horas del trayecto
		
		return "showRoutes";
	}
	
	@RequestMapping(value = "/showRoutes", method = RequestMethod.POST)
	public String signInPost(Model model, @Valid @ModelAttribute("reservation") Reservation reservation, BindingResult result, HttpSession session) {
		
		return "redirect:";
	}
	
	@ModelAttribute("reservation")
	public Reservation getReservation(){
		return new Reservation();
	}
	

}
