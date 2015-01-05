package com.miw.business;

import com.miw.model.Payment;
import com.miw.model.Reservation;

public interface ReservationManagerService {
	public boolean saveFullReservation(Reservation reservation, Payment payment) throws Exception;
}
