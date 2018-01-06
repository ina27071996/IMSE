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
 <!--- left column --->
 <div class = "container">
 <div style="background-color:#00CCCC opacity:0.5 !important" class="jumbotron">

    <h1 style="text-align: center">Database of Music Platform</h1>
     <img src="https://8tracks.com/assets/brand/8tracks_logo_blue-1e3b05eb940438026eff53085e3d7b9a7ce8a80c5823ac20695bcf31e0c2ea86.svg" align="middle"  alt="8tracks" width="600" height="150">
	 </div>
 <ul>
  <li>  <a href="http://localhost/imse/readUsers.php">Read users</a></li>
  <li>  <a href="http://localhost/imse/importUsers.php">Import</a></li>
  <li>  <a href="http://localhost/imse/deleteUser.php">Delete All</a></li>
</ul>
<br>
<?php
  if (isset($_GET['id'])) {
    $sql = "SELECT * FROM Users WHERE Id = " . $_GET['id'] . " ";
  } else if(!isset($_GET['id'])){
    $sql = "SELECT * FROM Users";
  }
  $result = $conn->query($sql);
?>
  <table class='table table-bordered'>
    <thead>
      <tr>		
		<th> <a href="http://localhost/imse/createUser.php">Create</a></li></th>
		<th> </th>
		<th>Username</th>
		<th>Password</th>
		<th>Join Date</th>
		<th>Profile Picture</th>
      </tr>
    </thead>
    <tbody>
<?php
  // fetch rows of the executed sql query
  while ($row = $result->fetch_assoc()) {
	echo "<tr>";
	echo "<td> <a href=\"updateUser.php?id=" . $row['Id'] . "\">Update</a> </td>";
	echo "<td> <a href=\"deleteUser.php?id=" . $row['Id'] . "\">Delete</a> </td>";
	echo "<td>" . $row['Username'] . "</td>";
	echo "<td>" . $row['Password'] . "</td>";
    echo "<td>" . $row['JoinDate'] . "</td>";
	echo "<td>" . $row['ProfilePicture'] . "</td>";
    echo "</tr>";
  }
?>
    </tbody>
  </table>
<div>Total: <?php echo $result->num_rows; ?> found Users!</div>
 </div>
</body>
</html>