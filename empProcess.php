<?php
print_r($_REQUEST);
include('empDbConnect.php');
echo "<link href='main.css' rel='stylesheet' type='text/css'>";
if ($_REQUEST['submit'] == "X") {
    $sql = "DELETE FROM employees WHERE id = $_REQUEST[id]";
    ##  echo $sql;
    if ($conn->query($sql)) {
        header("Location: viewEmp.php");
    }
}

elseif  ($_REQUEST['submit'] == "Insert Entry")
{    $sql = "INSERT INTO employees (first_name, last_name, address, pay_type, pay_delivery, emp_union, salary) VALUES ('$_REQUEST[f_name]', '$_REQUEST[l_name]', '$_REQUEST[address]', $_REQUEST[pay_type], $_REQUEST[pay_delivery], '$_REQUEST[emp_union]', $_REQUEST[salary] )";
    echo "<p>Query: " . $sql . "</p>\n<p><strong>";
    if ($conn->query($sql))
        echo "Inserted $_REQUEST[f_name]";
    else
        echo "Not inserted";

}
elseif ($_REQUEST['viewTC'] && isset($_REQUEST['id']))
{   
    echo 'here';    
    $sql = "SELECT * FROM time_card WHERE employee=%d;";
    $sql = sprintf($sql,$_REQUEST['id']);
    $result = $conn->query($sql);
    $empnamesql = "SELECT first_name, last_name FROM employees where id =" .  $_REQUEST['id'] ." ";
    $empnameresult = $conn->query($empnamesql);
    $emp_name = mysqli_fetch_assoc($empnameresult);
    if ($result->num_rows > 0) {
        // output data of each row
        echo "<table>";
        echo    "<tr>";
        echo    "<th>Employee</th>";
        echo    "<th>Date:</th>";
        echo    "<th>Hours:</th>";
        echo    "<th>Amount Due:</th>";
        echo    "</tr>";

        while($row = $result->fetch_assoc()) {
            echo "<tr>";
            echo "<td>" . implode(" ",$emp_name) . "</td>";
            echo "<td>" . $row["date"] . "</td>";
            echo "<td>" . $row["hours"] . "</td>";
            echo "<td>'$$$'</td>"; 
            echo "</tr>";

        }
        echo "</table>";
    }else{

     echo 'No Time Cards';   
    } 
   
    
}
elseif ($_REQUEST['viewSR'] && isset($_REQUEST['id']))
{
    echo 'here';    
    $sql = "SELECT * FROM sales_recipts WHERE employee=%d;";
    $sql = sprintf($sql,$_REQUEST['id']);
    $result = $conn->query($sql);
    $empnamesql = "SELECT first_name, last_name FROM employees where id =" .  $_REQUEST['id'] ." ";
    $empnameresult = $conn->query($empnamesql);
    $emp_name = mysqli_fetch_assoc($empnameresult);
    if ($result->num_rows > 0) {
        // output data of each row
        echo "<table>";
        echo    "<tr>";
        echo    "<th>Employee</th>";
        echo    "<th>Date:</th>";
        echo    "<th>Hours:</th>";
        echo    "<th>Amount Due:</th>";
        echo    "</tr>";

        while($row = $result->fetch_assoc()) {
            echo "<tr>";
            echo "<td>" . implode(" ",$emp_name) . "</td>";
            echo "<td>" . $row["date"] . "</td>";
            echo "<td>" . $row["hours"] . "</td>";
            echo "<td>'$$$'</td>"; 
            echo "</tr>";

        }
        echo "</table>";
    }else{

     echo 'No Time Cards';   
    } 
}
?>