<?php
    session_start();    
    include_once("dbc.php");
    include_once("logincheck.php");
    include_once("header.php");
?>
<link href="main.css" rel="stylesheet" type="text/css">
<?php
    
    if ($_POST['submit'] == "X") {
        $sql = "DELETE FROM employees WHERE id = $_POST[id]";
    
        if ($conn->query($sql)) {
            header("Location: viewEmp.php");
        }
    }
    
    elseif  ($_POST['submit'] == "Insert Entry") {
        
        $pass = md5($_POST['emp_pass']);
        
        $sql = "INSERT INTO employees (first_name, last_name, address, pay_type, pay_delivery, emp_union, salary, password, user_level) VALUES ('$_POST[f_name]', '$_POST[l_name]', '$_POST[address]', $_POST[pay_type], $_POST[pay_delivery], '$_POST[emp_union]', $_POST[salary], '$pass', 0 )";
        
        echo "<strong><p>Query: " . $sql . "</p>\n<p></strong>";
        if ($conn->query($sql)){
            header("Location: main.php");
        }

    }
    elseif ($_POST['viewTC'] && isset($_POST['id'])) {   
        
    
$sql = "SELECT * FROM time_card WHERE employee = ". $_POST['id'];
$result = $conn->query($sql);
$emp_sql = "SELECT first_name, last_name FROM employees, time_card WHERE employees.id = time_card.employee and employees.id =". $_POST['id'];
$emp_result = $conn->query($emp_sql);
        ?>

<h1><?php 
        $emp_name = mysqli_fetch_assoc($emp_result);
        echo implode(" ",$emp_name); ?> Timecards</h1>
<table border="1">
    <tr>
        <th>id:</th>
        <th>Employee</th>
        <th>Date:</th>
        <th>Hours:</th>
        <th>Amount Due:</th>
    </tr>
    <?php

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {

        echo "<form id='deleteForm' name='deleteForm' method='post' action='timeCardProcess.php'><tr><td>" . $row["id"] . "</td>";
        echo "<td>" . implode(" ",$emp_name) . "</td>";
        echo "<td>" . $row["date"] . "</td>";
        echo "<td>" . $row["hours"] . "</td>";
        echo "<td>'$$$'</td>";
       
        
    }
}
    }

?>