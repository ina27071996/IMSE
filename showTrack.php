<?php
session_start();
include "functions.inc.php";
$conn = connect();
?>
<!DOCTYPE html>
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

<body >
<?php
                if (isset($_GET['id'])) {
                  $sql = "SELECT * FROM Track WHERE id = " . $_GET['id'] . " ";
                } else if(!isset($_GET['id'])){
                  $sql = "SELECT * FROM Track";
                }
                $result = $conn->query($sql);
             
     
            	
             echo "<td> <a href=\"track.php?id=" .  "\">Add Track</a> </td>";
?>        
            <table class='table table-bordered'>
 	 <thead>
 			
      <tr>
                <th></th>
                <th></th>
                <th>Title</th>
 				<th>Artist</th>
 				<th>Year</th>
				<th>Album</th>
                <th>Duration</th>
				<th> 
            </th>
    </tread>
    <tbody>	
     <?php
          // fetch rows of the executed sql query
          while ($row = $result->fetch_assoc()) {
            echo "<tr>";
            echo "<td> <a href=\"updateTrack.php?id=" . $row['id'] . "\">Update</a> </td>";
            echo "<td> <a href=\"deleteTrack.php?id=" . $row['id'] . "\">Delete</a> </td>";
            echo "<td>" . $row['track_title'] . "</td>";
            echo "<td>" . $row['artist'] . "</td>";
            echo "<td>" . $row['year'] . "</td>";
            echo "<td>" . $row['album'] . "</td>";
            echo "<td>" . $row['duration'] . "</td>";
            echo "</tr>";
          }
     ?>			
                
          </tbody>
         </table>
        <div>Total: <?php echo $result->num_rows; ?> found Tracks!</div>
        </div>
        </body>        
                 
 			
            
                  
        </html>
