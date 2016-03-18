  function statusChangeCallback(response) {
	    console.log('statusChangeCallback');
	    console.log(response);
	    // The response object is returned with a status field that lets the
	    // app know the current login status of the person.
	    // Full docs on the response object can be found in the documentation
	    // for FB.getLoginStatus().
	    if (response.status === 'connected') {
	      // Logged into your app and Facebook.
	      testAPI();
	    } else if (response.status === 'not_authorized') {
	      // The person is logged into Facebook, but not your app.
	      document.getElementById('status').innerHTML = 'Please log ' +
	        'into this app.';
	    } else {
	      // The person is not logged into Facebook, so we're not sure if
	      // they are logged into this app or not.
	      document.getElementById('status').innerHTML = 'Please log ' +
	        'into Facebook.';
	    }
	  }

	  // This function is called when someone finishes with the Login
	  // Button.  See the onlogin handler attached to it in the sample
	  // code below.
	  function checkLoginState() {
	    FB.getLoginStatus(function(response) {
	      statusChangeCallback(response);
	    });
	  }

	  window.fbAsyncInit = function() {
		    FB.init({
		      appId      : '140934972949592',
		      xfbml      : true,
		      version    : 'v2.5'
		    });
		  };

		  (function(d, s, id){
		     var js, fjs = d.getElementsByTagName(s)[0];
		     if (d.getElementById(id)) {return;}
		     js = d.createElement(s); js.id = id;
		     js.src = "//connect.facebook.net/en_US/sdk.js";
		     fjs.parentNode.insertBefore(js, fjs);
		   }(document, 'script', 'facebook-jssdk'));
		  

	  // Now that we've initialized the JavaScript SDK, we call 
	  // FB.getLoginStatus().  This function gets the state of the
	  // person visiting this page and can return one of three states to
	  // the callback you provide.  They can be:
	  //
	  // 1. Logged into your app ('connected')
	  // 2. Logged into Facebook, but not your app ('not_authorized')
	  // 3. Not logged into Facebook and can't tell if they are logged into
	  //    your app or not.
	  //
	  // These three cases are handled in the callback function.

	  FB.getLoginStatus(function(response) {
	    statusChangeCallback(response);
	  });

	 
	  // Here we run a very simple test of the Graph API after login is
	  // successful.  See statusChangeCallback() for when this call is made.
	  function testAPI() {
		  var url = '/me?fields=name,email';
		    FB.api(url, function (response) {
		    	
	        /*document.getElementById('status').innerHTML =
	         'Thanks for logging in, ' + response.name + '!';*/

	        // Pour recuperer la photo de profil, voir Quentin
	        var urlPhoto = "https://graph.facebook.com/" + response.id + "/picture";
	        $('#PhotoFb').empty();
	        $('#PhotoFb').append('<img href="/Offre/Home" " src="' + urlPhoto + '"></img>');

	        //$('#BoutonFb').hide();
	        // $('#BoutonDeco').append('<button href="#" onclick="disconnect()"> Deconnexion </button>');
	        $.post("/Offre/connectFB", {id: response.id, nom: response.name, prenom: response.name, email:response.email});
	    
	  })
	  }
  
	  
	  
  FB.ui({
	  method: 'send',
	  link: 'http%3A%2F%2Fwww.nytimes.com%2F2011%2F06%2F15%2Farts%2Fpeople-argue-just-to-win-scholars-assert.html',
	});
  
  FB.ui({
	  method: 'feed',
	  link: 'https://developers.facebook.com/docs/',
	  caption: 'An example caption',
	}, function(response){});
  
  FB.ui({
	  method: 'share',
	  href: 'https://developers.facebook.com/docs/',
	}, function(response){});