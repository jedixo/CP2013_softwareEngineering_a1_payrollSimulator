<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="main.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width; initial-scale=1; maximum-scale=1">
</head>

<body>
<?php include 'header.php'; 
// Hourly employees paued every friday
// Salary last working day of the month
// Comission payed evey even friday
    echo "hello \r\n";
    $info = getdate();
    echo "<pre>";
    print_r($info);
    echo "</pre>";
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

 echo date_format($commisionPayDay, 'Y-m-d');

    
//    echo "Today is ". $date ." of " . $month . ", ". $year.". The time is ". $hour . ":". $min .":". $sec;
    
    ?>

</body>
</html>