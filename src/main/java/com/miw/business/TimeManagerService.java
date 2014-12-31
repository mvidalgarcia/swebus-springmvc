package com.miw.business;

import java.util.Vector;

import com.miw.model.Time;

public interface TimeManagerService {
	public Vector<Time> getTimesByRoute(String cityFrom, String cityTo) throws Exception;
	public Time getTimeById(Integer id) throws Exception;
	
}
