package com.miw.persistance.reservation;

import impl.miw.persistence.reservation.ReservationDAO;

public class Test {

	public static void main(String[] args) throws Exception {
		ReservationDAO resDao = new ReservationDAO();
		
		/* OBTENER RESERVA A PARTIR DEL CÓDIGO */
		System.out.println(resDao.getReservation(0));
		System.out.println(resDao.getReservation(1));
		System.out.println(resDao.getReservation(2));
		
		/* ELIMINAR UNA RESERVA POR EL CÓDIGO */
		System.out.println("------");
		//System.out.println(resDao.deleteReservationByCode(34)); //False
		//System.out.println(resDao.deleteReservationByCode(2)); //True
		
		/* OBTENER TODAS LAS RESERVAS DE UN USUARIO POR SU ID */
		System.out.println("------");
		System.out.println(resDao.getReservationsByIdUser(0));
		//System.out.println(resDao.getReservationsByIdUser(1));
	}

}
