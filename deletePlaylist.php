<?php
session_start();
include "functions.inc.php";
$conn = connect();
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

    <h1 style="text-align: center">Music Platform</h1>
     
	 </div>
 <div>
	  <div>
<ul>
  <li>  <a href="http://localhost/imse/playlistlast.php">Playlists</a></li>
</ul>
 </div>

<?php
  //Handle insert
  if (isset($_GET['id'])) 
  {
     $sql = "DELETE FROM Playlist WHERE Id = " . $_GET['id'] . " ";
	 $result = $conn->query($sql);
	 header("Location: http://localhost/imse/playlistlast.php");
	 exit();
  }
  else
  {
     $sql = "DELETE FROM Playlist";
	 $result = $conn->query($sql);
	 header("Location: http://localhost/imse/playlistlast.php");
	 exit();
  }
?>

<br>

 </div>
 </div>
</body>
</html>