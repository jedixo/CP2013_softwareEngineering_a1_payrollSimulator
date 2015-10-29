<?php
include('dbc.php');
include_once("logincheck.php");
include_once("header.php");
?>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Timecards</title>
<link href="main.css" rel="stylesheet" type="text/css">
</head>
    <body>

<h1>Employee Database:</h1>
<table border="1">
    <tr>
        <th>id:</th>
        <th>Employee</th>
        <th>Date:</th>
        <th>Hours:</th>
        <th>Amount Due:</th>
    </tr>

<?php
$sql = "SELECT * FROM time_card WHERE employee = ". $_SESSION['emp_id'];
$result = $conn->query($sql);
$emp_sql = "SELECT first_name, last_name FROM employees, time_card WHERE employees.id = time_card.employee and employees.id =". $_SESSION['emp_id'];
$emp_result = $conn->query($emp_sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {

        echo "<form id='deleteForm' name='deleteForm' method='post' action='timeCardProcess.php'><tr><td>" . $row["id"] . "</td>";
        $emp_name = mysqli_fetch_assoc($emp_result);
        echo "<td>" . implode(" ",$emp_name) . "</td>";
        echo "<td>" . $row["date"] . "</td>";
        echo "<td>" . $row["hours"] . "</td>";
        echo "<td>'$$$'</td>";
       
        
    }
} else {
    echo "0 results";
}
$conn->close();
?>
    
</table>
</html>
