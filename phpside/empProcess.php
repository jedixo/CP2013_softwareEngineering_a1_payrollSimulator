<?php
include('empDbConnect.php');

if ($_REQUEST['submit'] == "X") {
    $sql = "DELETE FROM employees WHERE id = $_REQUEST[id]";
    ##  echo $sql;
    if ($conn->query($sql)) {
        header("Location: viewEmp.php");
    }
}
elseif  ($_REQUEST['submit'] == "Insert Entry")
{    $sql = "INSERT INTO employees (first_name, last_name, address, pay_type, pay_delivery, emp_union, salary) VALUES ('$_REQUEST[f_name]', '$_REQUEST[l_name]', '$_REQUEST[address]', $_REQUEST[pay_type], $_REQUEST[pay_delivery], '$_REQUEST[emp_union]', $_REQUEST[salary] )";
    echo "<p>Query: " . $sql . "</p>\n<p><strong>";
    if ($conn->query($sql))
        echo "Inserted $_REQUEST[f_name]";
    else
        echo "Not inserted";

}
?>