<?php
include('empDbConnect.php');
?>
<table border="1">
    <tr>
        <th>id:</th>
        <th>First:</th>
        <th>Last:</th>
    </tr>
<?php
$sql = "SELECT * FROM employees";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {

        echo "<tr><td>" . $row["id"] . "</td>"; 
        echo "<td>" . $row["first_name"] . "</td>";
        echo "<td>" . $row["last_name"] . "</td></tr>";
    }
} else {
    echo "0 results";
}
$conn->close();
?>
</table>