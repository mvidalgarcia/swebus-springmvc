/* Generated by Together */

package impl.miw.business.reservationmanager;


import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.ReservationManagerService;
import com.miw.model.Payment;
import com.miw.model.Reservation;
import com.miw.persistence.PaymentDataService;
import com.miw.persistence.ReservationDataService;

public class ReservationManager implements ReservationManagerService {

	@Autowired
	private ReservationDataService reservationDataService;
	@Autowired
	private PaymentDataService paymentDataService;

	@Override
	public boolean saveFullReservation(Reservation reservation, Payment payment) throws Exception {
		Integer idPayment=null;
		// Guardar el pago en BD y obtener el ID.
		System.out.println("[ReservationManager] Nos disponemos a guardar el pago en BD");
		idPayment = paymentDataService.newPayment(payment);
		System.out.println("[ReservationManager] Pago guardado en BD");
		//Insertar el id del pago en la reserva
		reservation.setIdPayment(idPayment);
		// Guardar la reserva en BD
		return reservationDataService.newReservation(reservation);
	}

}
