<?php
session_start();
if (!$_SESSION['loggedin']) {
    header("Location: index.php");
}
if (!isset($_SESSION['loggedin'])){
    header("Location: index.php");
}
?>