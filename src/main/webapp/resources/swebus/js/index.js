$(document).ready(function($) {
	
	$('#oneWayTrip').change(function() {
        if($(this).is(":checked")) {
        	$('#returnDate').hide()
        }
        else
        	$('#returnDate').show()
    });
	
});