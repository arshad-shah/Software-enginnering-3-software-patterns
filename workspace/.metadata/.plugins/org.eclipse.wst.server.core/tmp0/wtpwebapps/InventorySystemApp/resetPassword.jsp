<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
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
</head>
<body>
<div class="signUpContainer">
    <h1>Inventory management System</h1>
      <form class="signUpForm" action="FrontController" id="resetpass" method="post">
        	<h1 class="formHeading">Reset Password</h1>
	        <input class="input" name="username" size="18" type="text" placeholder="Username"/>
	        <input class="input" name="password" size="18" type="password" placeholder="New Password"/>
	        <input class="input" name="confirmPassword" size="18" type="password" placeholder="confirm New Password"/>
			
			<div class="loginFormButtons">
		      	<input type="hidden" name="action" value="ResetPassword" />
		      	<input class="button" type="submit" value="Reset Password" />
			</div>
	  </form>
  </div>
  
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#resetpass").validate({
            rules: {
            	username: "required",
            	password: "required",
            	confirmPassword: "required",
            },
             
            messages: {
            	username: "Username is required",
            	password: "New password is required",
            	confirmPassword: "Confirm password is required",
            }
        });
 
    });
</script>
</body>
</html>