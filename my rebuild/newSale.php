<?php
session_start();
include_once("logincheck.php");
include_once("header.php");
if ($_SESSION['pay_type'] != 2) {
    header("Location: index.php");
}
?>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Sale</title>
    <link href="main.css" rel="stylesheet">
</head>

<body>

<div id="wrapper">
       <div id="main">
        <div id="form">
            <h1>New Sale</h1>
            <form id="insert" name="insert" method="post" action="addSalesReceipt.php" enctype="multipart/form-data">
                <h2>Enter new Sale Amount</h2>
                <p>
                    <label>Sale amount: </label><br>
                    <input type="text" name="amount" id="amount" required>
                </p>
                <p>
                    <input type="submit" name="submit" id="submit" value="Insert Entry">
                    
                </p>
            </form>

        </div>
    </div>


</body>
</html>