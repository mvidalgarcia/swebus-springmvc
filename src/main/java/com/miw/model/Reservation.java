package com.miw.model;


import org.hibernate.validator.constraints.NotEmpty;

public class Reservation {
	private Integer code;
	private String cityFrom;
	private String cityTo;
	private Double price;
	@NotEmpty
	private String departureDate;
	private String returnDate;
	//Departure
	private Time departureTime;
	//Return
	private Time returnTime;
	private boolean oneWayTrip;
	private Integer numberAdults;
	private Integer numberYouths;
	private Integer numberStudents;
	private Integer numberSeniors;
	private Integer numberDisables;
	private Integer numberPets;
	private boolean extraBaggage;
	private boolean priorityBoarding;
	private boolean bike;
	private boolean insurance;
	private Integer idPayment;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getCityFrom() {
		return cityFrom;
	}
	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}
	public String getCityTo() {
		return cityTo;
	}
	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public boolean isOneWayTrip() {
		return oneWayTrip;
	}
	public void setOneWayTrip(boolean oneWayTrip) {
		this.oneWayTrip = oneWayTrip;
	}
	public Integer getNumberAdults() {
		return numberAdults;
	}
	public void setNumberAdults(Integer numberAdults) {
		this.numberAdults = numberAdults;
	}
	public Integer getNumberYouths() {
		return numberYouths;
	}
	public void setNumberYouths(Integer numberYouths) {
		this.numberYouths = numberYouths;
	}
	public Integer getNumberStudents() {
		return numberStudents;
	}
	public void setNumberStudents(Integer numberStudents) {
		this.numberStudents = numberStudents;
	}
	public Integer getNumberSeniors() {
		return numberSeniors;
	}
	public void setNumberSeniors(Integer numberSeniors) {
		this.numberSeniors = numberSeniors;
	}
	public Integer getNumberDisables() {
		return numberDisables;
	}
	public void setNumberDisables(Integer numberDisables) {
		this.numberDisables = numberDisables;
	}
	public Integer getNumberPets() {
		return numberPets;
	}
	public void setNumberPets(Integer numberPets) {
		this.numberPets = numberPets;
	}
	public boolean isExtraBaggage() {
		return extraBaggage;
	}
	public void setExtraBaggage(boolean extraBaggage) {
		this.extraBaggage = extraBaggage;
	}
	public boolean isPriorityBoarding() {
		return priorityBoarding;
	}
	public void setPriorityBoarding(boolean priorityBoarding) {
		this.priorityBoarding = priorityBoarding;
	}
	public boolean isBike() {
		return bike;
	}
	public void setBike(boolean bike) {
		this.bike = bike;
	}
	public boolean isInsurance() {
		return insurance;
	}
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public Time getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Time returnTime) {
		this.returnTime = returnTime;
	}
	public Integer getIdPayment() {
		return idPayment;
	}
	public void setIdPayment(Integer idPayment) {
		this.idPayment = idPayment;
	}
	@Override
	public String toString() {
		return "Reservation [code=" + code + ", cityFrom=" + cityFrom
				+ ", cityTo=" + cityTo + ", price=" + price
				+ ", departureDate=" + departureDate + ", returnDate="
				+ returnDate + ", departureTime=" + departureTime
				+ ", returnTime=" + returnTime + ", oneWayTrip=" + oneWayTrip
				+ ", numberAdults=" + numberAdults + ", numberYouths="
				+ numberYouths + ", numberStudents=" + numberStudents
				+ ", numberSeniors=" + numberSeniors + ", numberDisables="
				+ numberDisables + ", numberPets=" + numberPets
				+ ", extraBaggage=" + extraBaggage + ", priorityBoarding="
				+ priorityBoarding + ", bike=" + bike + ", insurance="
				+ insurance + ", idPayment=" + idPayment + "]";
	}
	
}
