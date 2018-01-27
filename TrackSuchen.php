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
<div class="container">
    <div style="background-color:#00CCCC opacity:0.5 !important" class="jumbotron">

        <h1 style="text-align: center">Database of Music Platform</h1>
        <img src="https://8tracks.com/assets/brand/8tracks_logo_blue-1e3b05eb940438026eff53085e3d7b9a7ce8a80c5823ac20695bcf31e0c2ea86.svg" align="middle"  alt="8tracks" width="600" height="150">
    </div>
    <h2 style = "text-align: center;">Search of tracks</h2>

    <br>

    <form id='searchform7' action='TrackSuchen.php' method='get'>
    <input id='search7' name='search7' type='text' size='20' placeholder="Enter title" value = '<?php isset($_GET['search7']) ? $_GET['search7'] : null; ?>'/>
    <input id='submit' type='submit' value='Search' />

        <button><a href= "Showtrack.php">Show all tracks</a></button>
    </form>
</div>


<?php
// check if search view of list view
if (isset($_GET['search7'])) {
    $sql = "SELECT * FROM Track WHERE track_title like '%" . $_GET['search7'] . "%' ORDER BY track_title";

// execute sql statement
$result = $conn->query($sql);
}
?>


<?php
if(!empty($result)){
    echo " <table style='border: 1px solid #DDDDDD'>";
    echo "    <thead>";
    echo  "   <tr>";
    echo  "      <th>Track Title</th>";
    echo  "      <th>Artist</th>";
    echo  "      <th>Year</th>";
    echo  "      <th>Album</th>";
    echo  "      <th>Duration</th>";
    echo   " </tr>";
    echo  " </thead>";
    echo   "<tbody>";
// fetch rows of the executed sql query
    while ($row = $result->fetch_assoc()) { echo "<tr>";
        echo "<td>" . $row['track_title'] . "</td>";
        echo "<td>" . $row['artist'] . "</td>";
        echo "<td>" . $row['year'] . "</td>";
        echo "<td>" . $row['album'] . "</td>";
        echo "<td>" . $row['duration'] . "</td>";
        echo "</tr>";
    }
    echo   "</tbody>";
    echo "</table>";
}else
{
    echo"<br>";
    echo"<h6>nothing yet to show, no search term introduced</h6>";
}
?>
    </tbody>
</table>
<br>
<button><a href= "Index.php">Back</a></button>
</body>
</html>
