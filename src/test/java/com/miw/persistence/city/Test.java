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
		
		/* OBTENER IDS DE CIUDADES A PARTIR DEL NOMBRE */
		System.out.println(cityDao.getIdByCityName("Linkoping"));
		System.out.println(cityDao.getIdByCityName("Stockholm"));
		System.out.println(cityDao.getIdByCityName("Madrid"));
		System.out.println(cityDao.getIdByCityName("Malmo"));
		
		/* OBTENER CIUDADES DE ORIGEN Y DESTINO POR EL ID ROUTE */
		System.out.println("----");
		System.out.println(cityDao.getCitiesByIdRoute(0).get("from") + " - " + cityDao.getCitiesByIdRoute(0).get("to")); //Stockholm - Linkoping
		System.out.println(cityDao.getCitiesByIdRoute(4).get("from") + " - " + cityDao.getCitiesByIdRoute(4).get("to")); //Malmo - Stockholm
		System.out.println(cityDao.getCitiesByIdRoute(2).get("from") + " - " + cityDao.getCitiesByIdRoute(2).get("to")); //Linkoping - Stockholm
	}

}
