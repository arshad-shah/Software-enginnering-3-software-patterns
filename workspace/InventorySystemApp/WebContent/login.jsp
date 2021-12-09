<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Inventory System Login</title>
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
	  <div class="loginContainer">
	    <h1>Inventory management System</h1>
	      <form class="loginForm" id="loginForm"action="FrontController" method="post">
	        	<h1 class="formHeading">Login</h1>
		        <input class="input" name="username" size="15" type="text" placeholder="Username"/>
		        <input class="input" name="password" size="15" type="password" placeholder="Password"/>
				
				<div class="loginFormButtons">
					<input type="hidden" name="action" value="LoginUser" />
			      	<input class="button" type="submit" value="login" />
				</div>
		  </form>
		  
		  <form action="FrontController" method="post">
			<div>
				<input type="hidden" name="action" value="SignUpUserClick" />
		      	<input class="button" type="submit" value="Signup" />
	      	</div>
		  </form>
		  
		  <form action="FrontController" method="post">
			<div>
				<input type="hidden" name="action" value="ResetPasswordClick" />
		      		Forgot Your Password:
		      	<input class="button" type="submit" value="Reset Password" />
	      	</div>
		  </form>
	  </div>
  </body>
  
  <script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
            	username: {
                    required: true,
                },
         
                password: "required",
            },
             
            messages: {
            	username: {
                    required: "Please enter username",
                },
                 
                password: "Please enter password"
            }
        });
 
    });
</script>
</html>
