<?php
session_start();
$mainSession = NULL;
if(!isset($_SESSION['main_session']))
{
   include "functions.inc.php";
   $conn = connect();
   $mainSession = $_SESSION['main_session'];
}



$id = $_GET['id']; // $id is now defined
$sql="DELETE FROM Collection WHERE id='$id'";

if ($conn->query($sql) === TRUE) {
    echo "Record deleted successfully";
} else {
    echo "Error deleting record: " . $conn->error;
}

?> 