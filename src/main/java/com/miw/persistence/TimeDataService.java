package com.miw.persistence;

import java.util.Vector;

import com.miw.model.Time;

public interface TimeDataService {
		public Vector<Time> getTimesByRoute(String cityFrom, String cityTo) throws Exception;
		public Time getTimeById(Integer id) throws Exception;
}