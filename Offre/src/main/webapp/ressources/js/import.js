/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Quand on a choisi un fichier 

    $("#file").change(function(){
        console.log("valeur changee");
        if($("#file").val() != ""){
            $("#submit").prop("disabled", false);
        }else{
            $("#submit").prop("disabled", true);
        }
    });

    $("#import").ajaxForm({
        beforeSubmit: function(arr, $form, options) {
            $("#submit").prop("disabled", true);
            $(".import-box.loading").show();
        },
        success: function(data){
            $(".import-box.loading").hide();
            $("#file").val(null);
            $("#submit").prop("disabled", true);
            $(".import-box.done").show();
            $(".import-box.done").delay(4000).fadeOut(400);
        },
        error: function(data, errorText){
            $(".import-box.loading").fadeOut(400);
            $(".import-box.fail").show();
            $(".import-box.fail").delay(4000).fadeOut(400);
        }
    });

    		