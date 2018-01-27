<?php
function connect(){

	$servername = "sql11.freesqldatabase.com";
	$username = "sql11214736";
	$password = "AUtSLeFRPX";
	$dbname = "sql11214736";
	$conn = mysqli_connect($servername, $username, $password, $dbname);
	@mysqli_set_charset($conn, "utf8");
	return $conn;
}
?>