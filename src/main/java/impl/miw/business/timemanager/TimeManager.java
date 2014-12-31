package impl.miw.business.timemanager;


import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.TimeManagerService;
import com.miw.model.Time;
import com.miw.persistence.TimeDataService;


public class TimeManager implements TimeManagerService {

	@Autowired
	private TimeDataService timeDataService;

	@Override
	public Vector<Time> getTimesByRoute(String cityFrom, String cityTo) throws Exception {
		return timeDataService.getTimesByRoute(cityFrom, cityTo);
	}

	@Override
	public Time getTimeById(Integer id) throws Exception {
		return timeDataService.getTimeById(id);
	}
}
