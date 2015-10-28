<?php
$serverName = "sql6.freemysqlhosting.net";
$userName = "sql689509";
$password = "lA7*wL7!";

// Create connection
$conn = new mysqli($serverName, $userName, $password, $userName);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
?>