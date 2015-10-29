<?php
session_start();
include_once("logincheck.php");
include_once("header.php");
if ($_SESSION['user_level'] != 1) {
    header("Location: index.php");
}
?>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Promote to Admin</title>
    <link href="main.css" rel="stylesheet">
</head>

<body>

<div id="wrapper">
       <div id="main">
        <div id="form">
            <h1>New Admin</h1>
            <form id="insert" name="insert" method="post" action="submitPromotion.php" enctype="multipart/form-data">
                <h2>Enter new Admin ID</h2>
                <p>
                    <label>Employee ID: </label><br>
                    <input type="text" name="emp_id" id="emp_id" required>
                </p>
                <p>
                    <input type="submit" name="submit" id="submit" value="Insert Entry">
                    
                </p>
            </form>

        </div>
    </div>


</body>
</html>