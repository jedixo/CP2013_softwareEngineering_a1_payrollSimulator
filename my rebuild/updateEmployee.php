<?php
session_start();
include_once("logincheck.php");
include_once("header.php");
?>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
    <link href="main.css" rel="stylesheet">
</head>

<body>

<div id="wrapper">
       <div id="main">
        <div id="form">
            <h1>Edit Details</h1>
            <form id="insert" name="insert" method="post" action="test.php" enctype="multipart/form-data">
                <h2>Edit Employee Details</h2>
                <p>
                    <label>First Name: </label><br>
                    <input type="text" name="f_name" id="f_name" required>
                </p>
                <p>
                    <label>Last Name: </label><br>
                    <input type="text" name="l_name" id="l_name" required>
                </p>
                <p>
                    <label>Address: </label><br>
                    <input type="text" name="address" id="address" required>
                </p>
                <p>
                    <label for="pay_type">Pay Type: </label><br>
                    <select name="pay_type">
                        <option value="0">Hourly</option>
                        <option value="1">Salary</option>
                        <option value="2">Comission</option>
                    </select>
                </p>
                <p>
                    <label>Pay Delivery: </label><br>
                    <select name="pay_delivery">
                        <option value="0">Mail</option>
                        <option value="1">Pick up</option>
                        <option value="2">Direct</option>
                    </select>
                </p>
                <p>
                    <label>Union: </label><br>
                    <input type="text" name="emp_union" id="emp_union" >
                </p>
                <p>
                    <label>Salary: </label><br>
                    <input type="text" name="salary" id="salary" >
                </p>
                <p>
                    <p>
                    <label>Password: </label><br>
                    <input type="text" name="emp_pass" id="emp_pass" required>
                </p>
                <p>
                    <input type="submit" name="edit" id="edit" value="Insert Entry">
                    
                </p>
            </form>

        </div>
    </div>


</body>
</html>