package com.miw.persistance.reservation;

import impl.miw.persistence.reservation.ReservationDAO;

public class Test {

	public static void main(String[] args) throws Exception {
		ReservationDAO resDao = new ReservationDAO();
		
		/* OBTENER RESERVA A PARTIR DEL CÓDIGO */
		System.out.println(resDao.getReservation(0));
		System.out.println(resDao.getReservation(1));
		System.out.println(resDao.getReservation(2));

	}

}
