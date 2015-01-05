package com.miw.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Payment {
	private Integer id;
	private String type;
	@NotNull
	private Long cardNumber;
	private String userName;
	private Integer pinCode;
	@NotEmpty
	@Email
	private String email;
	private Integer mobile;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMobile() {
		return mobile;
	}
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", type=" + type + ", cardNumber="
				+ cardNumber + ", userName=" + userName + ", pinCode="
				+ pinCode + ", email=" + email + ", mobile=" + mobile + "]";
	}
	

}
