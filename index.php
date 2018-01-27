<?php
session_start();
include "functions.inc.php";
$conn = connect();
?>
<!DOCTYPE html>
<<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    
<div style="text-align: center; font-size:55px;">Welcome to   <img src="https://8tracks.com/assets/brand/8tracks_logo_blue-1e3b05eb940438026eff53085e3d7b9a7ce8a80c5823ac20695bcf31e0c2ea86.svg" alt="8tracks" width="200" height="100">
	 </div>  
  <a href='login.php' class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-log-out"></span> Log out
        </a>
</div>
  <!-- Links -->
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Index.php">8Tracks</a>
    </div>
    <ul class="nav navbar-nav">
  
    <li> 
      <a class="nav-link" href='readUsers.php'>Users Administration</a>
    </li>
    <li> 
      <a class="nav-link" href='track.php'>Add Track</a>
    </li>
    <li> 
      <a class="nav-link" href='Showtrack.php'>Show Tracks</a>
    </li>
    <li >
      <a class="nav-link" href='playlistlast.php'>Playlist</a>
    </li>
    <li>
      <a class="nav-link" href=''>Show Playlist</a>
    </li>
    <li>
      <a class="nav-link" href='createAndReadCollection.php'>Create and Display Collection</a>
    </li>
    <li>
      <a class="nav-link" href='CollectionsSuchen.php'>Search Collection</a>
    </li>
    <li> 
      <a class="nav-link" href='TrackSuchen.php'>Search Track</a>
    </li>
    <li> 
      <a class="nav-link" href='PlaylistSuchen.php'>Search Playlist</a>
    </li>
    <ul class="navbar-nav">
    </ul>
    </div>
  </nav>

    <div class="container">
  <img src="header.gif" style="width:100%;">
</div>
    

    
	
	


          
        

    
    
  </body>

</html>