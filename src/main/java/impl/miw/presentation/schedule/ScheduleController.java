package impl.miw.presentation.schedule;


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
public class ScheduleController {
	
	@Autowired
	private TimeManager timeManager;
	
	@RequestMapping(value = "/showSchedules", method = RequestMethod.GET)
	public String showRoutesSchedules(Model model, @ModelAttribute("reservation") Reservation reservation, BindingResult result) throws Exception {
		System.out.println("[ScheduleController - showRoutesTimes] Entrando en Show Routes");
		model.addAttribute("reservation", reservation);
		System.out.println("[ScheduleController- showRoutesTimes] Estado de la reserva: " + reservation);
		// Bean auxiliar para recoger los IDs de los schedules seleccionados
		Schedules schedulesSelected = new Schedules();
		
		//Obtener precio y horas de la ruta de ida y vuelta (si es necesario)
		Vector<Time> schedulesDeparture = timeManager.getTimesByRoute(reservation.getCityFrom(), reservation.getCityTo());
		model.addAttribute("schedulesDeparture", schedulesDeparture);
		
		/* Establecemos por defecto como seleccionado el primer radio button. De esta forma
		 * nos evitamos problemas de validación, ya que siempre va a haber una opción marcada.
		 */
		schedulesSelected.setIdDepartureSchedule(schedulesDeparture.get(0).getId());
		
		if (!reservation.isOneWayTrip()){
			Vector<Time> schedulesReturn = timeManager.getTimesByRoute(reservation.getCityTo(), reservation.getCityFrom());
			model.addAttribute("schedulesReturn", schedulesReturn);
			schedulesSelected.setIdReturnSchedule(schedulesReturn.get(0).getId());
		}
		// Pasamos al modelo los horarios señalados por defecto
		model.addAttribute("schedulesSelected", schedulesSelected);
		return "showSchedules";
	}
	
	@RequestMapping(value = "/showSchedules", method = RequestMethod.POST)
	public String submitSchedule(Model model, @Valid @ModelAttribute("reservation") Reservation reservation, 
			@Valid Schedules schedulesSelected,BindingResult result, HttpSession session) throws Exception {
		// Pasar la sesión al modelo para imprimir el email.
		model.addAttribute("sessionUser", (String) session.getAttribute("sessionUser"));
		System.out.println("[ScheduleController - SubmitSchedule] ID scheduleDepartureSelected: " + schedulesSelected.getIdDepartureSchedule());
		System.out.println("[ScheduleController - SubmitSchedule] ID scheduleReturnSelected: " + schedulesSelected.getIdReturnSchedule());
		// Obtener de BD los horarios correspondientes a partir de los ID seleccionados y rellenar
		// datos de la reserva
		Time scheduleDeparture = timeManager.getTimeById(schedulesSelected.getIdDepartureSchedule());
		reservation.setDepartureTime(scheduleDeparture);
		if (!reservation.isOneWayTrip()){
			Time scheduleReturn = timeManager.getTimeById(schedulesSelected.getIdReturnSchedule());
			reservation.setReturnTime(scheduleReturn);
			reservation.setPrice(scheduleDeparture.getPrice() + scheduleReturn.getPrice());
		}
		else {
			reservation.setPrice(scheduleDeparture.getPrice());
		}
		System.out.println("[ScheduleController- submitSchedule] Estado de la reserva: " + reservation);
		return "redirect:showAdditionals";
	}
	
	@ModelAttribute("reservation")
	public Reservation getReservation(){
		return new Reservation();
	}
	

}
