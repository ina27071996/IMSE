<?php
session_start();
include "functions.inc.php";
$conn = connect();
?>

<!DOCTYPE html>
<html lang="de">
<head>
	<title>Playlists</title>
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
<body >
	<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="login.php">Logout</a></li>
				<li class="active"><a href="searchPlaylist.php">Search Playlist</a></li>
        
			</ul>
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
		
	
		   <h1 style="text-align: left">Playlists:</h1>
				<br>
				<h3 >Create a new playlist: </h3>
			
		<form id='insertform' action= 'playlistlast.php' method='get'>
        <table style='border: 1px solid #DDDDDD'>
            <thead>
            <tr>
                <th>Name</th>
                <th>Hashtag</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <tr>
				
                <td>
					<div class="input-group">
                    <input id='title' name='title' type='text' size='20' placeholder="Playlist Name"
                           value='<?php isset($_GET['title']) ? $_GET['title'] : null; ?>'/>
						   </div>
                </td>
                <td>
					<div class="input-group">
                    <input id='hashtag' name='hashtag' type='text' size='10' placeholder="#awesome"
                           value='<?php isset($_GET['hashtag']) ? $_GET['hashtag'] : null; ?>'/>
						   </div>
                </td>
                <td>
					<div class="input-group">
                    <input id='description' name='description' type='text' size='30' placeholder="music for..."
                           value='<?php isset($_GET['description']) ? $_GET['description'] : null; ?>'/>
						   </div>
                </td>
            </tbody>
        </table>
		<div class="input-group">
        <input id='submit' type='submit' class="btn btn-success" value='Create'/><br/>
</div>
    </form>

  <?php
  //Handle insert
    
    if (isset($_GET['title']) && isset($_GET['description'])) 
    {
      //Prepare insert statement
      $sql = "INSERT INTO Playlist(Name,Hashtag,Description) 
    VALUES('" . $_GET['title'] . "','"  . $_GET['hashtag'] . "','"  . $_GET['description'] . "')";
      //Parse and execute statement
    $result = $conn->query($sql);
      //Print potential errors and warnings
    //nice to have
    }
  ?>

  <?php
  if (isset($_GET['id'])) {
    $sql = "SELECT * FROM Playlist WHERE Id = " . $_GET['id'] . " ";
  } else if(!isset($_GET['id'])){
    $sql = "SELECT * FROM Playlist";
  }
  $result = $conn->query($sql);
?>

  <br>
  <br>
	<table class="table table-striped">
			<h3>Your playlists are:</h3> 
				<thead>
					<tr>
						<th>Name</th>
            			<th>Hashtag</th>
            			<th>Description</th>
						<th>Views</th>
						
					</tr>
				</thead>
				<tbody>
				
					<tr>
            <?php
						while ($row = $row = $result->fetch_assoc()) {
   							echo "<tr>";
   							echo "<td>" . $row['Name'] . "</td>";
                			echo "<td>" . $row['Hashtag'] . "</td>";
                			echo "<td>" . $row['Description'] . "</td>";
							echo "<td>" . $row['Views'] . "</td>";
							
							
							
        				echo "<td><a  href=\"editPlaylist.php?id=".$row['Id']."\"> Edit </a></td>";
							  echo "<td><a  href=\"deletePlaylist.php?id=".$row['Id']."\">Delete</a></td>";	
							   echo "<td><a  href=\"showTrack.php?id=".$row['Id']."\">Open Playlist</a></td>";	
							    
        				echo "</tr>";
   						 }
   					?>
					</tr>		
			</tbody>
		</table>
		
		<div>Total: <?php echo $result->num_rows; ?>  Playlists!</div>
		
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
		
</body>
</html>
