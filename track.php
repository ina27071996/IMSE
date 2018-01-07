<?php
session_start();
include "functions.inc.php";
$conn = connect();
$track_title="";
$artist="";
$year="";
$album="";
$duration="";

if (isset($_GET['track_title']) && isset($_GET['artist'])&& isset($_GET['year'])&& isset($_GET['album'])&& isset($_GET['duration'])) 
{
	$track_title = $_GET['track_title'];
	$artist = $_GET['artist'];
	$year = $_GET['year'];
	$album = $_GET['album'];
	$duration = $_GET['duration'];
}
?>


<!DOCTYPE html>
<html lang="de">
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
<div>
<ul>
<?php
echo "<td> <a href=\"Showtrack.php?id=" .  "\">Show Tracks</a> </td>";
?>
</ul>
 </div>
<div>
  <form id='insertform' action='track.php' method='get'>

	
		<form id='insertform' action='track.php' method='get'>

		<h3 >Add a new Track: </h3>
		
		<table class='table table-bordered'>
		<tr>
		  <td>Track Title</td>
		  <td>
			   <input id='track_title' name='track_title' type='text' value='<?php echo $track_title; ?>' />
		  </td>
		</tr>
		 <tr>
		  <td>Artist</td>
		  <td>
			   <input id='artist' name='artist' type='text' value='<?php echo $artist; ?>' />
		  </td>
		</tr>
		<tr>
		  <td>Year</td>
		  <td>
			   <input id='year' name='year' type='year'  value='<?php echo $year; ?>' />
		  </td>
		</tr>
		<tr>
		  <td>Album</td>
		  <td>
			   <input id='album' name='album' type='text'  value='<?php echo $album; ?>' />
		  </td>
		</tr>
		<tr>
		  <td>Duration</td>
		  <td>
			   <input id='duration' name='duration' type='text'  value='<?php echo $duration; ?>' />
		  </td>
		</tr>
		   </table>
		   <input id='submit' type='submit' class="btn btn-success" value='Insert' />
	 </form>
   </div>
   <?php
		

	 if (isset($_GET['track_title']) && isset($_GET['artist'])&& isset($_GET['year'])&& isset($_GET['album'])&& isset($_GET['duration'])) 
	 {
		echo "$track";
	   //Prepare insert statement
	   $sql = "INSERT INTO Track(track_title,artist,year,album,duration) 
	   VALUES('" . $_GET['track_title'] . "','"  . $_GET['artist'] . "','" . $_GET['year'] . "','" . $_GET['album'] . "','" . $_GET['duration'] . "')";
	   
	   //Parse and execute statement
	 $result = $conn->query($sql);
	
	 header("Location: http://localhost/imse/showTrack.php");
	 exit();
	
	}
	?>
				
			
			
	
</body>	


</html>
