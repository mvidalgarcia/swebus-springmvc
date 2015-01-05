package com.miw.persistence;

import com.miw.model.Reservation;

public interface ReservationDataService {
		public boolean newReservation(Reservation reservation) throws Exception;
}