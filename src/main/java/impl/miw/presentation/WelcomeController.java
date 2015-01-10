package impl.miw.presentation;

import java.util.ArrayList;
import java.util.List;

import impl.miw.business.citymanager.CityManager;

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
public class WelcomeController {
	
	@Autowired
	private CityManager cityManager;
	
	/*
	 * Setting / as request mapping url we are setting the default controller
	 * for the application.
	 */
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public String welcome(Model model, HttpSession session, @ModelAttribute("reservation") Reservation reservation, BindingResult result) throws Exception {
		System.out.println("Ejecutando controlador Welcome");
		String sessionUser = (String) session.getAttribute("sessionUser");
		model.addAttribute("sessionUser", sessionUser);
		System.out.println("Sesión: " + sessionUser);
		// Pasar ciudades al modelo
		getCities(model);
		// Aumentar el contador de visitas y pasarlo al modelo
		model.addAttribute("counter",Counter.getInstance().inc());
		return "index";
	}
	
	@RequestMapping(value= "/", method = RequestMethod.POST)
	public String searchRoutes(Model model, HttpSession session, @Valid @ModelAttribute("reservation") Reservation reservation, BindingResult result) throws Exception {
		System.out.println("Ejecutando controlador Welcome - SearchRoutes");
		WelcomeValidator welcomeValidator= new WelcomeValidator();
		welcomeValidator.validate(reservation, result);
		if (!result.hasErrors()){
			model.addAttribute("sessionUser", (String) session.getAttribute("sessionUser"));
			System.out.println("[WelcomeController] Estado de la reserva: " + reservation);
			return "redirect:showSchedules";
		}
		else {
			// Pasar ciudades al modelo
			getCities(model);
			// Pasar contador al modelo (sin incrementarlo)
			model.addAttribute("counter",Counter.getInstance().getCounter());
			return "index";
		}
	}
	
	@ModelAttribute("reservation")
	public Reservation getReservation(){
		return new Reservation();
	}
	
	// Pasar ciudades al modelo
	public void getCities(Model model) throws Exception{
		model.addAttribute("cities", cityManager.getCities());
		List<Integer> numbers = new ArrayList<Integer>();
		for ( int i = 0 ; i < 5 ; i ++ )
			numbers.add(i);
		model.addAttribute("numbers", numbers);
	}
	
}
