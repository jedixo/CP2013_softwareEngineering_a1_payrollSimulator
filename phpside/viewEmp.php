<?php
include('empDbConnect.php');
?>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>PHP SQLite Database Example (Phone Records)</title>
<link href="main.css" rel="stylesheet" type="text/css">
</head>
    <body>
<h1>Employee Database:</h1>
        <br>
        <form id='addForm' name='addForm' method='post' action='empProcess.php'><input type="button" name='Add' value='Add Employee'/></form>
<table border="1">
    <tr>
        <th>id:</th>
        <th>First:</th>
        <th>Last:</th>
        <th>Address:</th>
        <th>Pay Type:</th>
        <th>Pay Delivery:</th>
        <th>Union:</th>
        <th>Salary:</th>
        <th>Options:</th>
    </tr>

<?php
$sql = "SELECT * FROM employees";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {

        echo "<form id='deleteForm' name='deleteForm' method='post' action='empProcess.php'><tr><td>" . $row["id"] . "</td>"; 
        echo "<td>" . $row["first_name"] . "</td>";
        echo "<td>" . $row["last_name"] . "</td>";
        echo "<td>" . $row["Address"] . "</td>";
        switch($row["pay_type"]){
            case 0: echo "<td>" . Hourly . "</td>"; break;
            case 1: echo "<td>" . Salary . "</td>"; break;
            case 2: echo "<td>" . Comission . "</td>"; break;}
        switch($row["pay_delivery"]){
            case 0: echo "<td>" . Mail . "</td>" ;break;
            case 1: echo "<td>" . Pickup . "</td>";break;
            case 2: echo "<td>" . "Direct deposit" . "</td>";break;}
        echo "<td>" . $row["Union"] . "</td>";
        echo "<td>" . $row["Salary"] . "</td>";
        ?>
        <td><input type="hidden" name="id" value="<?php echo $row["id"]; ?>"/>
            <input type="submit" name="submit" value="Update Entry" />
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
