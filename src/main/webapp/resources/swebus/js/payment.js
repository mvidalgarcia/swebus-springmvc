$(document).ready(function($) {
	// Ocultar al principio ya que la opción marcada por defecto es Card Payment
	$('.form-swe-account').hide()
	if($('#radio-swe-acc').is(":checked")) {
        	$('.form-swe-account').show()
        }
	
	$('.radio-payment').change(function() {
        if($('#radio-swe-acc').is(":checked")) {
        	$('.form-swe-account').show()
        }
        else
        	$('.form-swe-account').hide()
    });
	
});