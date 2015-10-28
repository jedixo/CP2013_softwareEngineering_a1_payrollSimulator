<?php
session_start();
include_once("dbc.php");
include_once("logincheck.php");
if ($_SESSION['pay_type'] == 2) {
    $date = date("Y-m-d");
    $amount = $_POST['amount'];
    $sql = "INSERT INTO sales_recipts (employee, date, amount) VALUES ('$_SESSION[emp_id]', '$date', $amount)";
    echo $sql;
    if ($conn->query($sql)){
        header("Location: main.php");
    }
    
} else {
    header("Location: index.php");
}

?>