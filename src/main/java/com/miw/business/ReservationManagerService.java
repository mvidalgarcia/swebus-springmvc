package com.miw.business;

import com.miw.model.Payment;
import com.miw.model.Reservation;

public interface ReservationManagerService {
	public Integer saveFullReservation(Reservation reservation, Payment payment) throws Exception;
	public Reservation getReservation(Integer code) throws Exception;
	public boolean deleteReservationByCode(Integer code, Integer idUser) throws Exception; 
}
