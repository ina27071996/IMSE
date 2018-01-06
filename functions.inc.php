<?php
function connect(){

	$servername = "sql11.freemysqlhosting.net";
	$username = "sql11213547";
	$password = "xCmX9tm7ku";
	$dbname = "sql11213547";
	$conn = mysqli_connect($servername, $username, $password, $dbname);
	@mysqli_set_charset($conn, "utf8");
	return $conn;
}
?>
