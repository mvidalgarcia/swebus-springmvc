package com.miw.persistence.city;

import java.util.Vector;

import impl.miw.persistence.city.CityDAO;


import com.miw.model.City;

public class Test {

	public static void main(String[] args) throws Exception {
		
		CityDAO cityDao = new CityDAO();
		
		/* OBTENER CIUDADES */
		Vector<City> resultados = new Vector<City>();
		resultados = cityDao.getCities();
		for(City res : resultados){
			System.out.println(res);
		}
	}

}
