<?php
session_start();
include "functions.inc.php";
$conn = connect();
?>

<!DOCTYPE html>
<html lang="de">
<head>
	<title>Login</title>
</head>
	<meta charset="UTF-8">
   <link href="https://fonts.googleapis.com/css?family=Khula:300" rel="stylesheet">
   <link  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style>
@media (min-width: 1200px) {
    .container{
        max-width: 1800px;
    }
}

tr td {
  cursor: pointer;
  position: relative;
  padding: 12px 8px 12px 40px;
  list-style-type: none;
  background: #eee;
  font-size: 18px;
  transition: 0.2s;
  
  /* make the list items unselectable */
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Set all odd list items to a different color (zebra-stripes) */
tr td:nth-child(odd) {
  background: #f9f9f9;
}

/* Darker background-color on hover */
tr td:hover {
  background: #ddd;
}

</style>
<body>
	<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-collapse">
			
		</div>
	</nav>

	<div class="container">
		
	    <div class = "container">
	    <div style="background-color:#00CCCC opacity:0.5 !important" class="jumbotron">

	       <h1 style="text-align: center">Music Platform</h1>
	        
			<div style="text-align: center">
	             <img src="https://8tracks.com/assets/brand/8tracks_logo_blue-1e3b05eb940438026eff53085e3d7b9a7ce8a80c5823ac20695bcf31e0c2ea86.svg" alt="8tracks" width="200" height="100">
			</div>
	    </div>
	    <div>
	<div>
	
<?php

if($_SERVER["REQUEST_METHOD"] == "POST") {
      // username and password sent from form 
      
      $myusername = mysqli_real_escape_string($conn,$_POST['username']);
      $mypassword = mysqli_real_escape_string($conn,$_POST['password']); 
      
      $sql = "SELECT Id FROM Users WHERE Username = '$myusername' and Password = '$mypassword'";
      $result = $conn->query($sql);
      $row = $result->fetch_array(MYSQLI_ASSOC);
     // $active = $row['active'];
      
      $count = $result->num_rows;
      
      // If result matched $myusername and $mypassword, table row must be 1 row
		
      if($count == 1) {
         //session_register("myusername");
         $_SESSION['login_user'] = $myusername;
         
         header("location: /imse");
      }else {
         $error = "Your Login Name or Password is invalid";
      }
   }
?>
<div class="form">
<h1>Log In</h1>
<form action="login.php" method="post" name="login">
<input type="text" name="username" placeholder="Username" required />
<input type="password" name="password" placeholder="Password" required />
<input   name="submit" class="btn btn-success" type="submit" value="Login" />
</form>
<br>
<br>
<p><h4>Not registered yet? <a href='createUser.php'>Register here!</a></h4></p>
</div>
</body>
</html>