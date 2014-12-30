package impl.miw.presentation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.miw.model.Reservation;

public class WelcomeValidator implements Validator {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		
		return Reservation.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Reservation reservation = (Reservation) target;
		System.out.println("[WelcomeValidator] Validando número de pasajeros");
		if(reservation.getNumberAdults() == 0 && reservation.getNumberDisables() == 0 &&
				reservation.getNumberPets() == 0 && reservation.getNumberSeniors() == 0 &&
				reservation.getNumberStudents() == 0 && reservation.getNumberYouths() == 0)
			/* Se utiliza numberPets (a pesar de que es una validación general
			 * porque es el último que aparece en el formulario.
			 * De esta forma se puede aprovechar para hacer más validaciones personalizadas. */
			errors.rejectValue("numberPets", "index.error.passengers");
		
		if (reservation.getCityFrom().equals(reservation.getCityTo()))
			errors.rejectValue("cityTo","index.error.equalcities");
		
		if (!reservation.getDepartureDate().matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)"))
			errors.rejectValue("departureDate", "index.datepattern");
		
		/* Solo cuando el checkbox de One way trip está desactivado, validar los campos
		 * de returnDate. Tanto si está vacío como si cumple la regexp. */
		if (!reservation.isOneWayTrip()){
			if (reservation.getReturnDate().isEmpty())
				errors.rejectValue("returnDate", "index.returnday.empty");
			if (!reservation.getReturnDate().matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)"))
				errors.rejectValue("returnDate", "index.datepattern");
		}
	}

}
