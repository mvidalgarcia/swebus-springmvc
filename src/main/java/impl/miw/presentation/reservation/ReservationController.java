package impl.miw.presentation.reservation;


import impl.miw.business.reservationmanager.ReservationManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ReservationController {
	
	@Autowired
	ReservationManager reservationManager;

	@RequestMapping(value = "/reservationDetails/{codeReservation}", method = RequestMethod.GET)
	public String showReservationDetails(@PathVariable Integer codeReservation, Model model) throws Exception {
		System.out.println("[ReservationController - showReservationDetails]  Entrando en Reservation details");
		System.out.println("[ReservationController - showReservationDetails]  Código de la reserva: " + codeReservation);
		model.addAttribute("reservation", reservationManager.getReservation(codeReservation));
		return "reservationDetails";
	}

}
