package impl.miw.presentation.cancelation;

import impl.miw.business.reservationmanager.ReservationManager;
import impl.miw.business.usermanager.UserManager;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CancelationController {
	
	@Autowired
	ReservationManager reservationManager;
	@Autowired
	UserManager userManager;
	
	@RequestMapping(value = "/cancelation", method = RequestMethod.GET)
	public String showCancelationForm(Model model, @ModelAttribute("cancelation") Cancelation cancelation, BindingResult result, HttpSession session) {
		System.out.println("[CancelationController - showCancelationForm] Entrando en Reservation Cancelation form");
		// El usuario debe estar identificado para cancelar un pedido
		String sessionUser = (String) session.getAttribute("sessionUser");
		if (sessionUser == null)
			return "redirect:signIn";
		else
			return "cancelation";
	}
	
	@RequestMapping(value = "/cancelation", method = RequestMethod.POST)
	public String cancelReservationPost(Model model, @Valid @ModelAttribute("cancelation") Cancelation cancelation, BindingResult result, HttpSession session) throws Exception {
		System.out.println("[CancelationController - cancelReservationPost] Código de reserva a cancelar: "+cancelation.getCode());
		// Errores de validación
		if(result.hasErrors())
			return "cancelation";
		//Verificar si la reserva existe en el sistema antes de eliminarla.
		Integer idUser = userManager.findIdUserByEmail((String) session.getAttribute("sessionUser"));
		if(!reservationManager.deleteReservationByCode(cancelation.getCode(), idUser)){
			result.reject("cancelation.error");
			return "cancelation";
		}
	    return "redirect:";
	}

}
