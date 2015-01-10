package com.miw.persistence;

import java.util.HashMap;
import java.util.Vector;

import com.miw.model.City;

public interface CityDataService {
		public Vector<City> getCities() throws Exception;
		public Integer getIdByCityName(String cityName) throws Exception;
		public HashMap<String,String> getCitiesByIdRoute(Integer idRoute)  throws Exception;

}