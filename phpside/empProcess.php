<?php
include('empDbConnect.php');

if ($_REQUEST['submit'] == "X") {
	$sql = "DELETE FROM employees WHERE id = $_REQUEST[id]";
  ##  echo $sql;
	if ($conn->query($sql)) {
		header("Location: viewEmp.php");
    }
}
?>