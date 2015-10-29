<?php
include_once("logincheck.php");
$view = $_SESSION['user_level'];

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
if ($view == 1){
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
<a href=\"viewTimecard.php\">
    <div class=\"outer\">
      <div class=\"image\">

            </div>
            <p>View All Timecards</p>
    </div>
</a>
<a href=\"viewSalesreceipt.php\">
    <div class=\"outer\">
      <div class=\"image\">

            </div>
            <p>View Sales</p>
    </div>
</a>
<a href=\"promoteEmp.php\">
<div class=\"outer\">
        <div class=\"image\">

        </div>
        <p> Promote Employee</p>
    </div>
</a>
    <div class=\"outerpay\">
        <div class=\"image\">
        
        </div>
        <p> Pay employee</p>
    </div>";

} elseif ($view != 0) {
    session_unset();
    header("Location: index.php");
}
if ($_SESSION['pay_type'] == 0){
    echo "<a href=\"addTimecard.php\">
        <div class=\"outer\">
            <div class=\"image\">

            </div>
            <p>New Timecard</p>
        </div>
    </a>";
    echo "<a href=\"viewTimecardForEmp.php\">
        <div class=\"outer\">
            <div class=\"image\">

            </div>
            <p>Veiw Timecards</p>
        </div>
    </a>";
    } elseif ($_SESSION['pay_type'] == 2){
    echo "<a href=\"newSale.php\">
        <div class=\"outer\">
            <div class=\"image\">

            </div>
            <p>New Sale</p>
        </div>
    </a>";
}
    ?>
</body>
</html>