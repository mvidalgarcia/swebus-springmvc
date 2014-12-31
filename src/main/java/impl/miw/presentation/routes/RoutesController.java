package impl.miw.presentation.routes;


import java.util.Vector;

import impl.miw.business.timemanager.TimeManager;

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
import com.miw.model.Time;

@Controller
@SessionAttributes("reservation")
public class RoutesController {
	
	@Autowired
	private TimeManager timeManager;
	
	@RequestMapping(value = "/showRoutes", method = RequestMethod.GET)
	public String showRoutesTimes(Model model, @ModelAttribute("reservation") Reservation reservation, BindingResult result) throws Exception {
		System.out.println("[RoutesController - showRoutesTimes] Entrando en Show Routes");
		model.addAttribute("reservation", reservation);
		System.out.println("[RoutesController- showRoutesTimes] Estado de la reserva: " + reservation);
		//Obtener precio y horas de la ruta de ida y vuelta (si es necesario)
		Vector<Time> schedulesDeparture = timeManager.getTimesByRoute(reservation.getCityFrom(), reservation.getCityTo());
		model.addAttribute("schedulesDeparture", schedulesDeparture);
		if (!reservation.isOneWayTrip()){
			Vector<Time> schedulesReturn = timeManager.getTimesByRoute(reservation.getCityTo(), reservation.getCityFrom());
			model.addAttribute("schedulesReturn", schedulesReturn);
		}
		// Bean auxiliar para recoger los IDs de los schedules seleccionados
		Schedules schedulesSelected = new Schedules();
		model.addAttribute("schedulesSelected", schedulesSelected);
		
		return "showRoutes";
	}
	
	@RequestMapping(value = "/showRoutes", method = RequestMethod.POST)
	public String submitSchedule(Model model, @Valid @ModelAttribute("reservation") Reservation reservation, 
			@Valid Schedules schedulesSelected,BindingResult result, HttpSession session) throws Exception {
		System.out.println("[RoutesController - SubmitSchedule] ID scheduleDepartureSelected: " + schedulesSelected.getIdDepartureSchedule());
		System.out.println("[RoutesController - SubmitSchedule] ID scheduleReturnSelected: " + schedulesSelected.getIdReturnSchedule());
		Time scheduleDeparture = timeManager.getTimeById(schedulesSelected.getIdDepartureSchedule());
		Time scheduleReturn = timeManager.getTimeById(schedulesSelected.getIdReturnSchedule());
		// Rellenar datos de la reserva
		reservation.setDepartureTime(scheduleDeparture);
		reservation.setReturnTime(scheduleReturn);
		reservation.setPrice(scheduleDeparture.getPrice() + scheduleReturn.getPrice());
		System.out.println("[RoutesController- submitSchedule] Estado de la reserva: " + reservation);
		return "redirect:showAdditionals";
	}
	
	@ModelAttribute("reservation")
	public Reservation getReservation(){
		return new Reservation();
	}
	

}
