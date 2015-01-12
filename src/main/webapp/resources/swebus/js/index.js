$(document).ready(function($) {
	//$('#returnDate').show()
	if($('#oneWayTrip').is(":checked")){
		$('#returnDate').hide()
	}
	
	
	$('#oneWayTrip').change(function() {
        if($(this).is(":checked")) {
        	$('#returnDate').hide()
        }
        else
        	$('#returnDate').show()
    });
	
});