package com.miw.persistence;

import com.miw.model.Payment;

public interface PaymentDataService {
	// Return id payment	
	public Integer newPayment(Payment payment) throws Exception;
}