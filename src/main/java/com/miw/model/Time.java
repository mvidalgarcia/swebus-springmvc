package com.miw.model;

public class Time {
	private Integer id;
	private Integer idRoute;
	private Integer hourDeparture;
	private Integer hourArrival;
	private Double price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdRoute() {
		return idRoute;
	}
	public void setIdRoute(Integer idRoute) {
		this.idRoute = idRoute;
	}
	public Integer getHourDeparture() {
		return hourDeparture;
	}
	public void setHourDeparture(Integer hourDeparture) {
		this.hourDeparture = hourDeparture;
	}
	public Integer getHourArrival() {
		return hourArrival;
	}
	public void setHourArrival(Integer hourArrival) {
		this.hourArrival = hourArrival;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Time [id=" + id + ", idRoute=" + idRoute + ", hourDeparture="
				+ hourDeparture + ", hourArrival=" + hourArrival + ", price="
				+ price + "]";
	}

}
