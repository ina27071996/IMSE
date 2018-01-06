<?php
session_start();
$mainSession = NULL;
if(!isset($_SESSION['main_session']))
{
   include "functions.inc.php";
   $conn = connect();
   $mainSession = $_SESSION['main_session'];
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
 <div style="background-color:#00CCCC opacity:0.5 !important" class="jumbotron">

    <h1 style="text-align: center">Database of Music Platform</h1>
     <img src="https://8tracks.com/assets/brand/8tracks_logo_blue-1e3b05eb940438026eff53085e3d7b9a7ce8a80c5823ac20695bcf31e0c2ea86.svg" align="middle"  alt="8tracks" width="600" height="150">
	 </div>
 <div>
	  <div>
<ul>
  <li>  <a href="http://localhost/imse/readUsers.php">Read users</a></li>
</ul>
 </div>

<?php
	 $stringUsers = file_get_contents('Users.json');
	 $arrayUsers = json_decode($stringUsers);
	 
	 for ($i = 0; $i < count($arrayUsers); $i++) 
	 {     
		$sql = "INSERT INTO Users(Username,Password,JoinDate,ProfilePicture) 
		VALUES('" . $arrayUsers[$i]->Username . "','"  . $arrayUsers[$i]->Password . "',CURRENT_TIMESTAMP,'" . $arrayUsers[$i]->ProfilePicture . "')";
		$result = $conn->query($sql);
	 }
	 
	 header("Location: http://localhost/imse/readUsers.php");
	 exit();
?>

<br>

 </div>
 </div>
</body>
</html>