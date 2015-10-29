<?php
session_start();
include_once("dbc.php");
include_once("logincheck.php");
if ($_SESSION['user_level'] != 1) {
    header("Location: index.php");
}
$id = $_POST['emp_id'];
$sql = "update employees set user_level=1 where id = ". $id;
echo $sql;
if ($conn->query($sql)){header("Location: main.php");} else {header("Location: promoteEmp.php");}
?>