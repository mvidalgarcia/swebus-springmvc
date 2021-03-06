/* Generated by Together */

package impl.miw.business.citymanager;


import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.CityManagerService;

import com.miw.model.City;

import com.miw.persistence.CityDataService;


public class CityManager implements CityManagerService {

	@Autowired
	private CityDataService cityDataService;

	@Override
	public Vector<City> getCities() throws Exception {
		return this.cityDataService.getCities();
	}
}
