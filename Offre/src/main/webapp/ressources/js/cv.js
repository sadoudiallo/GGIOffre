
function reset() {    
    $("#employeur").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#titre").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#datedebut").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#datefin").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#description").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#titre").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#descriptioncomp").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#competence").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
//   ==================Pour la formation===============================
    $("#titref").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#descriptionf").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#niveauf").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#originef").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#datef").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#domainef").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#diplomef").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    
//  ==================Pour la Langue===============================
    $("#nomlangue").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("#niveaulangue").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
//  ==================Pour le loisir===============================
    $("#loisir").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
//  ==================Info===============================
    $("#info").closest("div.form-group").show().find("input").prop("disabled", false).val("");
    //  ==================Pour le titre===============================
      $("#nomtitre").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
      $("#nomNewtitre").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    

    $("a").show();
   $("button").show();
   $("button[title='Valider']").hide();
   $("button[title='Reset']").hide();
   $("a[title='Ajouter']").show();
   $("a[title='Competence']").show();
   $("a[title='Formation']").show();
   $("a[title='Langue']").show();
   $("a[title='Loisir']").show();
   $("a[title='TitreCv']").show();
    $("input").prop("disabled", true);
    
}

function creerExperience() {    
	   reset();
    
    $(this).closest("div").find("input").prop("disabled", false);
    $("#info").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
    $("button[title='Reset']").show();
    $("button[title='Valider']").show();
    $("a[title='Competence']").show();
    $("a[title='Ajouter']").show();
    
    // affichage du bloc de de experience
    $("#employeur").closest("div.form-group").show().find("input").prop("disabled", false).val("");
    $("#titre").closest("div.form-group").show().find("input").prop("disabled", false).val("");
    $("#datedebut").closest("div.form-group").show().find("input").prop("disabled", false).val("");
    $("#datefin").closest("div.form-group").show().find("input").prop("disabled", false).val("");
    $("#description").closest("div.form-group").show().find("input").prop("disabled", false).val("");
    
}

function creerComptence(){
	   reset();
	 $(this).closest("div").find("input").prop("disabled", false);
	    $("button[title='Reset']").show();
	    $("button[title='Valider']").show();
	    $("a[title='Competence']").show();
	    $("a[title='Ajouter']").show();
	    $("#info").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
	    $("#descriptioncomp").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	    $("#competence").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	   
	
}

function creerLangue(){
	   reset();
	 $(this).closest("div").find("input").prop("disabled", false);
	    $("button[title='Reset']").show();
	    $("button[title='Valider']").show();
	    $("#info").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
	    $("#nomlangue").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	    $("#niveaulangue").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	   
	
}

function creerTitre(){
	   reset();
	 $(this).closest("div").find("input").prop("disabled", false);
	    $("button[title='Reset']").show();
	    $("button[title='Valider']").show();
	    $("#info").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
	    $("#nomtitre").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	    $("#nomNewtitre").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	   
	
}


function creerLoisir(){
	   reset();
	 $(this).closest("div").find("input").prop("disabled", false);
	    $("button[title='Reset']").show();
	    $("button[title='Valider']").show();
	    $("#info").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
	    $("#loisir").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	    
	   
	
}

function creerFormation(){
	   reset();
	 $(this).closest("div").find("input").prop("disabled", false);
	 $("button[title='Reset']").show();
	    $("button[title='Valider']").show();
	    $("#info").closest("div.form-group").hide().find("input").prop("disabled", true).val("");
	 $("#titref").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	    $("#descriptionf").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	    $("#niveauf").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	    $("#originef").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	    $("#datef").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	    $("#domainef").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	    $("#diplomef").closest("div.form-group").show().find("input").prop("disabled", false).val("");
	
}

function annuler() {
    reset();
    $(this).hide(); // hide valider
    $(this).prev().hide(); // hide annuler    
}

$(document).ready(function() {      
    reset();
 
    
    $("#valider").closest("div.form-group").find("a[title='Ajouter']").click( creerExperience );
    $("#valider").closest("div.form-group").find("a[title='Competence']").click( creerComptence );
    $("#valider").closest("div.form-group").find("a[title='Formation']").click( creerFormation );
    $("#valider").closest("div.form-group").find("a[title='Langue']").click( creerLangue );
    $("#valider").closest("div.form-group").find("a[title='Loisir']").click( creerLoisir );
    $("#valider").closest("div.form-group").find("a[title='TitreCv']").click( creerTitre );
    
    
   
});