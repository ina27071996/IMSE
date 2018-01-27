<?php
session_start();
include "functions.inc.php";
$conn = connect();



$id = $_GET['id']; // $id is now defined
$sql="DELETE FROM Collection WHERE id='$id'";

if ($conn->query($sql) === TRUE) {
    echo "Record deleted successfully";
} else {
    echo "Error deleting record: " . $conn->error;
}
header("Location: http://localhost/imse/createAndReadCollection.php");

?> 