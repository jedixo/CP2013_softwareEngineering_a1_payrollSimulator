<?php session_start();
if ($_SESSION["loggedin"]) {
    header('Location: main.php');
}
?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Log in</title>
<link href="main.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1">
</head>

    <body>
        <h1>Please enter your Employee ID and Password</h1>
        <?php
        echo "<form id=\"insert\" name=\"insert\" method=\"post\" action=\"login.php\" enctype=\"multipart/form-data\">
            <label for=\"emp_id\">Employee ID: </label>
            <br>
                    <input type=\"text\" name=\"emp_id\" id=\"emp_id\" required>
            <br>
            <label>Password: </label>
            <br>
                    <input type=\"password\" name=\"emp_pass\" id=\"emp_pass\"  required>
            <br><br>
            <input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Log In\">
        </form>"
        ?>
    </body>
</html>