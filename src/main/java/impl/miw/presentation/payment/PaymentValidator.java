package impl.miw.presentation.payment;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.miw.model.Payment;

public class PaymentValidator implements Validator {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class clazz) {
		
		return Payment.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Payment payment= (Payment) target;
		System.out.println("[PaymentValidator] Validando campos de Swebus Account (si existen)");
		
		/* Solo cuando el método de pago es Swebus account se comprueba si el usuario ha escrito
		 * los campos de userName y pinCode */
		if (payment.getType().equals("swebusaccount")){
			if (payment.getUserName().isEmpty())
				errors.rejectValue("userName", "payment.username.error");
			try {
				payment.getPinCode().toString().isEmpty();
			}
			catch (Exception e){
				errors.rejectValue("pinCode", "payment.pincode.error");
			}
			
			
		}
	}

}
