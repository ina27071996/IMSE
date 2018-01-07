<?php
session_start();
include "functions.inc.php";
$conn = connect();
?>

<!DOCTYPE html>
<html lang="de">
<head>
	<title>Collections of user</title>
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
				<li class="active"><a href="login.html">Logout</a></li>
        <li class="active"><a href=\"CollectionsSuchen.php">Search through collections</a></li>
        <li class="active"><a href=\"PlaylistSuchen.php">Search through playlists</a></li>
        <li class="active"><a href=\"TrackSuchen.php">Search through tracks</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<h2 style = "text-align: center;">Edit the collection</h2>
		
				<br>
				<h3 >Change the collection: </h3>
			
		 <form id='updateForm' action='updateCollection.php' method='get'>
        <table class='table table-bordered'>
        <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <input id='title' name='title' type='text' size='20' placeholder="Collection A"
                           value='<?php isset($_GET['title']) ? $_GET['title'] : null; ?>'/>
                </td>
                <td>
                    <input id='description' name='description' type='text' size='30' placeholder="music for..."
                           value='<?php isset($_GET['description']) ? $_GET['description'] : null; ?>'/>
                </td>
          </tbody>
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
    $sql = "UPDATE Collection SET" .
  " Title='" . $_GET['title'] . 
  "', Description='" . $_GET['description'] . 
  "' WHERE Id=" . $_GET['hiddenId'];
    //Parse and execute statement
    $result = $conn->query($sql);
    //Print potential errors and warnings
  //nice to have
  
   header("Location: http://localhost/imse/createAndReadCollection.php");
   exit();
  }
?>
  
</body>
</html>
