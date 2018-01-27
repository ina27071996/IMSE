<?php
session_start();
include "functions.inc.php";
$conn = connect();

$username="";
$password="";
$profilePicture="";

if(isset($_GET['Username']) && isset($_GET['Password']))
{
	$username = $_GET['Username'];
	$password = $_GET['Password'];
	$profilePicture = $_GET['ProfilePicture'];
}
?>


<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<style>
	ul {
		list-style-type: none;
		margin: 0;
		padding: 0;
		overflow: hidden;
		background-color: #333;
	}
	
	li {
		float: left;
		border-right: 1px solid #bbb;
	}
	
	li a {
		display: block;
		color: white;
		text-align: center;
		padding: 14px 16px;
		text-decoration: none;
	}
	
	li a:hover:not(.active) {
		background-color: #111;
	}
	
	.active {
		background-color: #4CAF50;
	}

	li:last-child {
    	border-right: none;
	}
	input[type=text] {
    		width: 100%;
    		box-sizing: border-box;
	}
</style>
</head>
<body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
 <!--- left column --->
 <div class = "container">
<div style="text-align: center; font-size:55px;">Welcome to   <img src="https://8tracks.com/assets/brand/8tracks_logo_blue-1e3b05eb940438026eff53085e3d7b9a7ce8a80c5823ac20695bcf31e0c2ea86.svg" alt="8tracks" width="200" height="100">
	 </div>
 <div>
	  <div>
<ul>
  <li>  <a href="http://localhost/imse/index.php">Home</a></li>
  <li>  <a href="http://localhost/imse/readUsers.php">All users</a></li>
</ul>
 </div>
<div>
  <form id='insertform' action='createUser.php' method='get'>
 <table class='table table-bordered'>
     <tr>
       <td>Username</td>
	   <td>
            <input id='Username' name='Username' type='text' value='<?php echo $username; ?>' />
       </td>
	 </tr>
	  <tr>
       <td>Password</td>
	   <td>
			<input id='Password' name='Password' type='password' value='<?php  echo $password; ?>' />
       </td>
	 </tr>
	 <tr>
       <td>Profile Picture</td>
	   <td>
			<input id='ProfilePicture' name='ProfilePicture' type='text'  value='<?php  echo $profilePicture; ?>' />
       </td>
	 </tr>
        </table>
        <input id='submit' type='submit' class="btn btn-success" value='Insert' />
  </form>
</div>
<?php
  //Handle insert
  if (isset($_GET['Username']) && isset($_GET['Password'])) 
  {
    //Prepare insert statement
    $sql = "INSERT INTO Users(Username,Password,JoinDate,ProfilePicture) 
	VALUES('" . $_GET['Username'] . "','"  . $_GET['Password'] . "',CURRENT_TIMESTAMP,'" . $_GET['ProfilePicture'] . "')";
    //Parse and execute statement
  $result = $conn->query($sql);
  
	 header("Location: http://localhost/imse/index.php");
	 exit();
  }
?>


<br>

 </div>
 </div>
</body>
</html>