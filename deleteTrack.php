<?php
session_start();
include "functions.inc.php";
$conn = connect();



$id = $_GET['id']; // $id is now defined
$sql="DELETE FROM Track WHERE id='$id'";

if ($conn->query($sql) === TRUE) {
    echo "Record deleted successfully";
} else {
    echo "Error deleting record: " . $conn->error;
}

?> 
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
<?php

echo "<td> <a href=\"track.php?id=" .  "\">Back to add Track</a> </td>";
echo "<td> <a href=\"showTrack.php?id=" .  "\">Back to Show Track</a> </td>";

?>
</body>
</html>