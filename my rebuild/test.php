<?php
    include_once("dbc.php");
    include_once("logincheck.php");
    print_r($_POST);
    
    if ($_POST['submit'] == "X") {
        $sql = "DELETE FROM employees WHERE id = $_POST[id]";
    
        if ($conn->query($sql)) {
            header("Location: viewEmp.php");
        }
    }
    
    elseif  ($_POST['submit'] == "Insert Entry") {
        
        $pass = md5($_POST['emp_pass']);
        
        $sql = "INSERT INTO employees (first_name, last_name, address, pay_type, pay_delivery, emp_union, salary, password, user_level) VALUES ('$_POST[f_name]', '$_POST[l_name]', '$_POST[address]', $_POST[pay_type], $_POST[pay_delivery], '$_POST[emp_union]', $_POST[salary], '$pass', 0 )";
        
        echo "<strong><p>Query: " . $sql . "</p>\n<p></strong>";
        if ($conn->query($sql)){
            header("Location: main.php");
        }

    }
    elseif ($_POST['viewTC'] && isset($_POST['id'])) {   
    
    $sql = "select employees.first_name, employees.last_name, time_card.date, time_card.hours from employees inner join time_card on employees.id = time_card.employee where employee.id = ". $_POST[id];
        echo $sql;
        $result=$conn->query($sql);
        foreach($result as $row){
            echo $row['first_name'];
            echo $row['last_name'];
            echo $row['date'];
            echo $row['hours'];
        }
   
    }

?>