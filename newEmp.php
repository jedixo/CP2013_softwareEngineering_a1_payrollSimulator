<?php
include('empDbConnect.php');
?>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Employee</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<form id="insert" name="insert" method="post" action="empProcess.php">
    <fieldset class="subtleSet">
        <h2>Insert new Employee:</h2>
        <p>
            <label for="f_name">First Name: </label>
            <input type="text" name="f_name" id="f_name">
        </p>
        <p>
            <label for="l_name">Last Name: </label>
            <input type="text" name="l_name" id="l_name">
        </p>
        <p>
            <label for="address">Address: </label>
            <input type="text" name="address" id="address">
        </p>
        <p>
            <label for="pay_type">Pay Type: </label>
            <input type="text" name="pay_type" id="pay_type">
        </p>
        <p>
            <label for="pay_delivery">Pay delivery: </label>
            <input type="text" name="pay_delivery" id="pay_delivery">
        </p>
        <p>
            <label for="union">Union: </label>
            <input type="text" name="union" id="union">
        </p>
        <p>
            <label for="salary">Salary: </label>
            <input type="text" name="salary" id="salary">
        </p>
        <p>
            <input type="submit" name="submit" id="submit" value="Insert Entry">
        </p>
    </fieldset>
</form>
</body>