<?php
include('dbc.php');
include('logincheck.php');
?>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>View Sales</title>
<link href="main.css" rel="stylesheet" type="text/css">
</head>
    <body>
<?php
include("header.php");
?>
<h1>Sales Database:</h1>
<table border="1">
    <tr>
        <th>id:</th>
        <th>Employee</th>
        <th>Date:</th>
        <th>Amount Due:</th>
    </tr>

<?php
$sql = "SELECT * FROM sales_recipts";
$result = $conn->query($sql);
$emp_sql = "SELECT first_name, last_name FROM employees, sales_recipts WHERE employees.id = sales_recipts.employee";
$emp_result = $conn->query($emp_sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {

        echo "<form id='deleteForm' name='deleteForm' method='post' action='timeCardProcess.php'><tr><td>" . $row["id"] . "</td>"; 
//        echo "<pre>";
//        print_r($emp_result);
        $emp_name = mysqli_fetch_assoc($emp_result);
//        echo "<br>";
//        print_r($emp_name);
//        echo"</pre>";
        echo "<td>" . implode(" ",$emp_name) . "</td>";
        echo "<td>" . $row["date"] . "</td>";
        echo "<td>" . $row["amount"] . "</td>";
       
        ?>
        <td><input type="hidden" name="id" value="<?php echo $row["id"]; ?>"/>
            <?php
        echo "<input type='submit' name='submit' value='Update Entry' />";

        ?>
            
<input type="submit" name="submit" value="X" class="deleteButton"></td></tr></form>
    <?php
    }
} else {
    echo "0 results";
}
$conn->close();
?>
    
</table>
</html>
