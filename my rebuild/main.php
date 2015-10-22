<?php
include_once("logincheck.php");
if ($_SESSION['user_level'] == "administrator"){
    $view = 2;
} else {
    $view = 1;
}
?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Main Menu</title>
<link href="main.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1">
</head>

<body>
<?php
    include_once("header.php");
    ?>
<?php
if ($view == 2){
    echo "<a href=\"newEmployee.php\">
<div class=\"outer\">
        <div class=\"image\">
        
        </div>
        <p> add new employee</p>
</div>
</a>
<a href=\"viewEmp.php\">
    <div class=\"outer\">
      <div class=\"image\">

            </div>
            <p> view employee</p>
    </div>
</a>
<div class=\"outer\">
        <div class=\"image\">
        
        </div>
        <p> promote employee</p>
    </div>
    <div class=\"outerpay\">
        <div class=\"image\">
        
        </div>
        <p> Pay employee</p>
    </div>";
} elseif ($view == 1){
echo "NOTHING HERE YET!!!";
}
    ?>
</body>
    <footer>
        <form action="logout.php">
        <input type="submit" value="logout">
        </form>
            </footer>
</html>