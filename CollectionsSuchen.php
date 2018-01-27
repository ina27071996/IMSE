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
        <div style="text-align: center">
                <img src="https://8tracks.com/assets/brand/8tracks_logo_blue-1e3b05eb940438026eff53085e3d7b9a7ce8a80c5823ac20695bcf31e0c2ea86.svg" alt="8tracks" width="300" height="100">
           </div>
    </div>

    <br>
    <form id='searchform7' action='CollectionsSuchen.php' method='get'>
        <input id='search1' name='search1' type='text' size='20' placeholder="Enter title" value = '<?php isset($_GET['search1']) ? $_GET['search1'] : null; ?>'/>
        <input id='submit' type='submit' value='Search' />

           <button><a href="createAndReadCollection.php">Show all collections</a></button>
     </form>
    </div>
<?php
if (isset($_GET['search1'])) {
    $sql = "SELECT * FROM Collection WHERE title LIKE '%" . $_GET['search1'] . "%' ORDER BY title";
    $result = $conn->query($sql);
}
?>

<?php
if(!empty($result)){
    echo " <table style='border: 1px solid #DDDDDD'>";
    echo "    <thead>";
    echo  "   <tr>";
    echo  "      <th>Title</th>";
    echo  "      <th>Description</th>";
    echo   " </tr>";
    echo  " </thead>";
    echo   "<tbody>";
// fetch rows of the executed sql query
    while ($row = $result->fetch_assoc()) { echo "<tr>";
        echo "<td>" . $row['Title'] . "</td>";
        echo "<td>" . $row['Description'] . "</td>";
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
