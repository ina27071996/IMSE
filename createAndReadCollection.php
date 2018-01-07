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
<body>
	<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/login">Logout</a></li>
				<li class="active"><a href=\"CollectionsSuchen.php">Search through collections</a></li>
				<li class="active"><a href=\"PlaylistSuchen.php">Search through playlists</a></li>
				<li class="active"><a href=\"TrackSuchen.php">Search through tracks</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<h2 style = "text-align: center;">Collection</h2>
		
				<br>
				<h3 >Create a new collection: </h3>
			
		<form id='insertform' action= 'createAndReadCollection.php' method='get'>
        <table style='border: 1px solid #DDDDDD'>
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
        <input id='submit' type='submit' name='submit_button' value='Insert'/><br/>

    </form>

	<?php
	//Handle insert
	  
	  if (isset($_GET['title']) && isset($_GET['description'])) 
	  {
	    //Prepare insert statement
	    $sql = "INSERT INTO Collection(Title,Description) 
		VALUES('" . $_GET['title'] . "','"  . $_GET['description'] . "')";
	    //Parse and execute statement
	  $result = $conn->query($sql);
	    //Print potential errors and warnings
		//nice to have
	  }
	?>

	<?php
	  if (isset($_GET['id'])) {
	    $sql = "SELECT * FROM Collection WHERE Id = " . $_GET['id'] . " ";
	  } else if(!isset($_GET['id'])){
	    $sql = "SELECT * FROM Collection";
	  }
	   $result = $conn->query($sql);
	?>

		<table class="table table-striped">
			<h3>Your collections are:</h3> 
				<thead>
					<tr>
						<th>Title</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
				
						<?php
							while ($row = $result->fetch_assoc()) {
	   							echo "<tr>";
	      					    echo "<td>" . $row['Title'] . "</td>";
								echo "<td>" . $row['Description'] . "</td>";
	        					echo "<td><a href= \"showCollections.php?id=".$row['Id']."\"> Edit </a></td>";
								echo "<td><a href= \"deleteCollections.php?id=".$row['Id']."\">Delete</a></td>";	
	        					echo "</tr>";
	   						}
	   					?>		
			</tbody>
		</table>
		<div>Total: <?php echo $result->num_rows; ?> found Collections!</div>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
		
	
</body>
</html>