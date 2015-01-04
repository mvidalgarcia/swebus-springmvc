package impl.miw.presentation.payment;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.model.Payment;
import com.miw.model.Reservation;

@Controller
@SessionAttributes("reservation")
public class PaymentController {

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String showPaymentForm(Model model, @ModelAttribute("reservation") Reservation reservation,
			@ModelAttribute("payment") Payment payment, BindingResult result) {
		System.out.println("[PaymentController - showPaymentForm]  Entrando en Payment form");
		System.out.println("[PaymentController - showPaymentForm] Estado de la reserva: " + reservation);
		// Método de pago por defecto (evita validaciones)
		payment.setType("card");
		return "payment";
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String sumbmitPaymentForm(Model model, @ModelAttribute("reservation") Reservation reservation,
			@Valid @ModelAttribute("payment") Payment payment, BindingResult result) {
		PaymentValidator paymentValidator= new PaymentValidator();
		paymentValidator.validate(payment, result);
		if (result.hasErrors()){
			return "payment";
		}
		else {
			System.out.println("[PaymentController - sumbmitPaymentForm] Datos del pago: " + payment);
			// Guardar la reserva y el pago en la BD.
			return "redirect:index";
		}
	}

}
