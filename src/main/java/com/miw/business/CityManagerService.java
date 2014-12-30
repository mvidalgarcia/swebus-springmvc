package com.miw.business;

import java.util.Vector;
import com.miw.model.City;

public interface CityManagerService {
	public Vector<City> getCities() throws Exception;
	
}
