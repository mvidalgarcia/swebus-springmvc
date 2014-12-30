package com.miw.persistence;

import java.util.Vector;
import com.miw.model.City;

public interface CityDataService {
		public Vector<City> getCities() throws Exception;

}