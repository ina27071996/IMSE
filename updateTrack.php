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
<?php
  if (isset($_GET['id'])) {
    $sql = "SELECT * FROM Track WHERE id = " . $_GET['id'] . " ";
	$result = $conn->query($sql);
	$row = $result->fetch_assoc();
    $track_title = $row['track_title'];
	$artist = $row['artist'];
    $year = $row['year'];
    $album = $row['album'];
    $duration = $row['duration'];
  }
  else
  {
	$track_title = $_GET['track_title'];
	$artist = $_GET['artist'];
	$year = $_GET['year'];
	$album = $_GET['album'];
	$duration = $_GET['duration'];
  }
  
   
?>
  <form id='updateForm' action='updateTrack.php' method='get'>
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
     <input id='hiddenId' name='hiddenId' type='hidden'  value='<?php echo  $_GET['id'] ?>' />
        <input id='submit' type='submit' class="btn btn-success" value='Update' />
</form>
</div>
<?php
  //Handle insert
  if (isset($_GET['hiddenId'])) 
  {
    //Prepare update statement
    $sql = "UPDATE Track SET" .
	" track_title='" . $_GET['track_title'] . 
	"', artist='" . $_GET['artist'] . 
    "', year='" . $_GET['year'] . 
    "', album='" . $_GET['album'] . 
    "', duration='" . $_GET['duration'] . 
	"' WHERE Id=" . $_GET['hiddenId'];
    //Parse and execute statement
    $result = $conn->query($sql);
    //Print potential errors and warnings
	//nice to have
	
	 header("Showtrack.php");
	 exit();
  }
?>
<br>
 </div>
 </div>
</body>
</html>