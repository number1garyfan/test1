<?php

    error_reporting(E_ALL);
    ini_set("display_errors", 1);

    define('servername', '127.0.0.1');
    define('username', 'user');
    define('password', 'SecureZaoan1!');
    define('database', 'ICT3103');

    $mysqli = new mysqli(servername, username, password, database);

    if($mysqli->connect_error) {
      exit('Error connecting to database');
    }
    mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
    $mysqli->set_charset("utf8mb4");

?>