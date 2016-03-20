function check() {
    if($("#password").val() != $("#vpassword").val() && $("#vpassword").val() != "") {
        $(".error_passwrd").text('Mauvaise correspondance de mot de passe');
        $("#valider").prop('disabled', 'true');
    }
    else {
        $(".error_passwrd").text('');
        $("#valider").removeAttr('disabled');
    }
}
$(document).ready(function() {   
    $("#vpassword").change( check );
    $("#password").change( check );
});


