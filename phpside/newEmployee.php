<?php
include("empDbConnect.php");
?>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Employee </title>
    <link href="mainstyle.css" rel="stylesheet">
</head>

<body>
<div id="wrapper">
       <div id="main">
        <div id="form">
            <h1>New Employee</h1>
            <form id="insert" name="insert" method="post" action="empProcess.php" enctype="multipart/form-data">
                <h2>Insert new artist:</h2>
                <p>
                    <label for="f_name">First Name: </label><br>
                    <input type="text" name="f_name" id="f_name" required>
                </p>
                <p>
                    <label for="l_name">Last Name: </label><br>
                    <input type="text" name="l_name" id="l_name" required>
                </p>
                <p>
                    <label for="address">address: </label><br>
                    <input type="text" name="address" id="address" required>
                </p>
                <p>
                    <label for="pay_type">Pay Type: </label><br>
                    <input type="text" name="pay_type" id="pay_type" required>
                </p>
                <p>
                    <label for="pay_delivery">Pay Delivery: </label><br>
                    <input type="text" name="pay_delivery" id="pay_delivery" required>
                </p>
                <p>
                    <label for="emp_union">Union: </label><br>
                    <input type="text" name="emp_union" id="emp_union" >
                </p>
                <p>
                    <label for="salary">Salary: </label><br>
                    <input type="text" name="salary" id="salary" >
                </p>
                <p>
                    <input type="submit" name="submit" id="submit" value="Insert Entry">
                    <?php
                    ?>
                </p>
            </form>

        </div>
    </div>


</body>
</html>