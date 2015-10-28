<?php
session_start();
include_once("dbc.php");

$sql = "Select password, user_level, pay_type from employees where id=". $_POST['emp_id'];
$result=$conn->query($sql);


foreach($result as $row){
    $pass = $row['password'];
    $user_level = $row['user_level'];
    $pay = $row['pay_type'];
}

if (md5($_POST['emp_pass']) === $pass){
    $_SESSION['loggedin'] = true;
    $_SESSION['emp_id'] = $_POST['emp_id'];
    $_SESSION['emp_pass'] = $_POST['emp_pass'];
    $_SESSION['user_level'] = $user_level;
    $_SESSION['pay_type'] = $pay;
    header("Location: main.php");
}
else {
    header("Location: index.php");
}
?>