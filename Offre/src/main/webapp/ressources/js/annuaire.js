function reset() {    
    $("#nom").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#lieu").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#idlabel").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#tel").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    
   $("button").show();
   $("button[title='telephone']").show();

}

function affichertel(){
	   reset();
	 $(this).closest("div").find("input").prop("disabled", false);
	 $("button[title='telephone']").hide();
	 $("#tel").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	    
	   
	
}

$(document).ready(function() {      
    reset();
    $("#telephone").closest("div.form-group").find("button[title='telephone']").click( affichertel );
});