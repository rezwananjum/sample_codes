<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<link rel="stylesheet" href="">
</head>
<body>
	<script>
		// initialize and setup facebook js sdk
		window.fbAsyncInit = function() {
		    FB.init({
		      appId      : 'XXXXXXXXXX', // your app id 
		      xfbml      : true,
		      version    : 'v2.5'
		    });
		    FB.getLoginStatus(function(response) {
		    	if (response.status === 'connected') {
		    		document.getElementById('status').innerHTML = 'We are logged into fb and app.';
		    		document.getElementById('login').style.visibility = 'hidden';
		    	} else if (response.status === 'not_authorized') {
		    		document.getElementById('status').innerHTML = 'We are not logged in fb but not in app.'
		    	} else if (response.status === 'unknown'){
		    		document.getElementById('status').innerHTML = 'You are not logged into Fb and app.';
		    	}
		    });
		};
		(function(d, s, id){
		    var js, fjs = d.getElementsByTagName(s)[0];
		    if (d.getElementById(id)) {return;}
		    js = d.createElement(s); js.id = id;
		    js.src = "//connect.facebook.net/en_US/sdk.js";
		    fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
		
		// login with facebook with extra permissions
		function login() {
			FB.login(function(response) {
				if (response.status === 'connected') {
		    		document.getElementById('status').innerHTML = 'We are connected.';
		    		document.getElementById('login').style.visibility = 'hidden';
		    	} else if (response.status === 'not_authorized') {
		    		document.getElementById('status').innerHTML = 'We are not logged in.'
		    	} else {
		    		document.getElementById('status').innerHTML = 'You are not logged into Facebook.';
		    	}
			}, {scope: 'email'});
		}
		
		// getting basic user info
		function getInfo() {
			FB.api('/me', 'GET', {fields: 'picture.width(150).height(150)'}, function(response) {
				document.getElementById('status').innerHTML = "<img src='" + response.data.url + "'>";
			});
		}
		
		function getInfopeople(a) {

			// this part is not working
			///{user id}?fields=picture

			
			var user_id = "/"+a+"/profilePic";
			//var c = a;
			console.log(user_id);
			FB.api(user_id,'GET', {fields:'picture.width(150).height(150).redirect:false'}, function(response) {
				console.log(response);
				document.getElementById('user_status').innerHTML = "<img src='" + response.profilePic.data.url + "'>";
			});
		}


	</script>

	<div id="status"></div>
	<h2>Fetching profile picture by login</h2>
	<button onclick="getInfo()">Get your picture</button>
	<button onclick="login()" id="login">Login</button>


		
		<div id="user_status"></div>
		
		       <h2>Fetching profile picture by username</h2>
			    <input type="text" id="a" name="a">
				<button onclick="getInfopeople(document.getElementById('a').value)">See Profile pic</button>
		


</body>
</html>