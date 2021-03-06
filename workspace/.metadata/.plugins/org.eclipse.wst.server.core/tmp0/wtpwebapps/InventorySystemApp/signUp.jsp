<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Nunito&display=swap" rel="stylesheet">
	<script
	  src="https://code.jquery.com/jquery-3.4.1.min.js"
	  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	  crossorigin="anonymous"></script>
	<script type="text/javascript"
	    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
<title>SignUp</title>
</head>
<body>
<div class="signUpContainer">
    <h1>Inventory management System</h1>
      <form class="signUpForm" action="FrontController" id="signUp" method="post">
        	<h1 class="formHeading">SignUp</h1>
       		<input class="input" name="name" size="18" type="text" placeholder="name"/>
	        <input class="input" name="username" size="18" type="text" placeholder="Username"/>
	        <input class="input" name="password" size="18" type="password" placeholder="Password"/>
			
			<div class="loginFormButtons">
		      	<input type="hidden" name="action" value="SignUpUser" />
		      	<input class="button" type="submit" value="Signup" />
			</div>
	  </form>
  </div>
  
<script type="text/javascript"> 
    $(document).ready(function() {
        $("#signUp").validate({
            rules: {
            	name: "required",
            	username: "required",
            	password: "required",
            },
             
            messages: {
            	name: "name is required",
            	username: "Username is required",
            	password: "Password is required",
            }
        });
 
    });
</script>
</body>
</html>