package com.miw.persistence;

import com.miw.model.Reservation;

public interface ReservationDataService {
		public Integer newReservation(Reservation reservation) throws Exception;
		public Reservation getReservation(Integer code) throws Exception;
}