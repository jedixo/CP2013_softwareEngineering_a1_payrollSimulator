<?php
session_start();
print_r($_SESSION);
include_once("dbc.php");
include_once("logincheck.php");
if ($_SESSION['pay_type'] == 0) {
    $date = date("Y-m-d");
    $hour = date(h);
    if (date(a) == "pm"){
        $hour += 12;
        if ($hour == 24){$hour -= 12;}
    }
    $sql = "INSERT INTO time_card (employee, date, hours) VALUES ('$_SESSION[emp_id]', '$date', $hour)";
    echo $sql;
    if ($conn->query($sql)){
        header("Location: main.php");
    }
    
} else {
    header("Location: index.php");
}

?>