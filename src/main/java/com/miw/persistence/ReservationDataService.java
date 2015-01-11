package com.miw.persistence;

import java.util.Vector;

import com.miw.model.Reservation;

public interface ReservationDataService {
		public Integer newReservation(Reservation reservation) throws Exception;
		public Reservation getReservation(Integer code) throws Exception;
		public boolean deleteReservationByCode(Integer code, Integer idUser) throws Exception;
		public Vector<Reservation> getReservationsByIdUser(Integer idUser) throws Exception;
}