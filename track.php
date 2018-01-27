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
</style>
	</head>
<body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
 
 <div class = "container">
 <div style="background-color:#00CCCC opacity:0.5 !important" class="jumbotron">
    <h1 style="text-align: center">Database of Music Platform</h1>
     <img src="https://8tracks.com/assets/brand/8tracks_logo_blue-1e3b05eb940438026eff53085e3d7b9a7ce8a80c5823ac20695bcf31e0c2ea86.svg" align="middle"  alt="8tracks" width="600" height="150">
	 </div>
 <ul>
  <li>  <a href="Showtrack.php">Show Tracks</a></li>
  <li>  <a href="Index.php">Back</a></li>
</ul>
<br>
<div>
  <form id='insertform' action='track.php' method='get'>
  <table class='table table-bordered'>	
		<h3 >Add a new Track: </h3>
		
		
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
	
	 header("Location: http://localhost/imse/ShowTrack.php");
	 exit();
	
	}
	?>
				
			
			
	
</body>	


</html>
