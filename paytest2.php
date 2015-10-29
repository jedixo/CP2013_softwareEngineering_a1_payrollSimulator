<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="main.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1">
<?php include('empDbConnect.php'); ?>
</head>

<body>
<?php include 'header.php'; 
// Hourly employees paued every friday
// Salary last working day of the month
// Comission payed evey even friday
//    echo "hello \r\n";
//    $info = getdate();
//    echo "<pre>";
//    print_r($info);
//    echo "</pre>";  
    $date = $info['mday'];
    $month = $info['month'];
    $year = $info['year'];
    $hour = $info['hours'];
    $min = $info['minutes'];
    $sec = $info['seconds'];
    $weekday = $info['weekday'];
    $numOfDays = cal_days_in_month(CAL_GREGORIAN, $info['mon'], $year);
    $numOfWeeksInMonth = floor($numOfDays/7);
    $weekNumber = $date / 7;
    $commisionPayDay = date_create('2015-30-0');
    $nextCommisionPayDay = date_add($commisionPayDay, date_interval_create_from_date_string('14 days'));
    echo date_format($nextCommisionPayDay, 'Y-m-d H:i:s');
    echo "<br>";    
    $lastWeekdayOfMonth = date('l jS \of F Y A', strtotime('last weekday' . $numOfDays . ' ' . ' ' . $month . ' ' . $year));
    echo "<br>";
    echo "<pre>";
    print_r($nextCommisionPayDay);
    print_r($commisionPayDay);
    echo "</pre>";
//    if ($date % 2 == 0) {
//      echo "PaydDay!";
//    }
//    else{
//        echo "non me gusta";
//    }
//    echo date_format($commisionPayDay, 'Y-m-d');
    if ($weekday == "Firday"){
        echo "Hourly Employees are to be payed today.";
        echo "<br>";
        echo "<br>";
            if ($date == $commisionPayDay) {
                echo "Comission is payed today. ";
                echo "<br>";
                date_add($commisionPayDay, date_interval_create_from_date_string('14 days'));
                date_add($nextCommisionPayDay, date_interval_create_from_date_string('14 days'));
                if ($date ==  $lastWeekdayOfMonth){
                    echo "Pay salaries today. ";
                    echo "<br>";
                    }
                else{
                    echo "Pay Salaries on ";
                    echo $lastWeekdayOfMonth;
                    echo ".";
                }
                    
                }
            else{
                echo "Comission is to be payed on <><>. ";
                echo "Pay Salaries on ";
                echo $lastWeekdayOfMonth;
                echo ".";
            }
        }
    else{
        echo "Pay Hourly Wages on Friday. ";
        echo "Comission is to be payed on ";
        echo date_format($nextCommisionPayDay, 'd/m/Y');
        echo ". ";
        echo "Pay Salaries on ";
        echo $lastWeekdayOfMonth;
        echo ".";
    }

echo "<br>";
$sql = "SELECT * FROM employees, time_card WHERE employees.id = time_card.employee";
$result = $conn->query($sql);
echo "<h2>Time Cards</h2>";
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
//        echo "<pre>";
//        print_r($row);
//        echo "</pre>";
        echo "<a>" . $row["first_name"];
        echo " " . $row["last_name"] . "</a>";
        echo " is due $";
        echo $row["hours"] * $row["Salary"] ."<br>";
//        if ($row["pay_delivery"] == 0){
//            
//        echo "heaar";
//        }
//        while($row["pay_delivery"] == 0){
//            $account_sql = "SELECT account FROM mail_pay WHERE empID = " . $row[employee] ;
//            echo "heaar";
//            $oldAccount = $conn->query($account_sql);
//            echo $oldAccount;
//            $newAccount = $oldAccount + ($row["hours"] * $row["Salary"]);
//            echo $newAccount;
//            $conn->query("UPDATE mail_pay SET account = $newAccount WHERE empID = $row[employee]");
//        }


    }
}
echo "<h2>Sales Reciepts</h2>";
$sales_sql = "SELECT * FROM employees, sales_recipts WHERE employees.id = sales_recipts.employee";
$sales_result = $conn->query($sales_sql);
if ($sales_result->num_rows > 0) {
    // output data of each row
    while($row = $sales_result->fetch_assoc()) {
//        echo "<pre>";
//        print_r($row);
//        echo "</pre>";
        echo "<a>" . $row["first_name"];
        echo " " . $row["last_name"] . "</a>";
        echo " is due $";
        echo $row["amount"] ."<br>";
    }
}
    
//    echo "Today is ". $date ." of " . $month . ", ". $year.". The time is ". $hour . ":". $min .":". $sec;
    
    ?>

</body>
</html>