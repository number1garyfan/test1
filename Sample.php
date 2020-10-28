<?php
require_once("HelperClass/EncryptAPIKey.php");
require_once("HelperClass/PasswordHelper.php");

//    
//    $smysql = mysqli_connect( "127.0.0.1:3306", "root", "SecureZaoan1!" );
//    mysqli_select_db($smysql,'Busbly'); 
    
    // Create connection
    $conn = mysqli_connect("47.254.213.126:3306", "root", "95*a_U46", "Busbly");
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
      }

      $sql = "SELECT * FROM Account";
      $result = $conn->query($sql);

      if ($result->num_rows > 0) {
        // output data of each row
        while($row = $result->fetch_assoc()) {
          echo "id: " . $row["Username"]."<br>";
        }
      } else {
        echo "0 results";
      }
      $conn->close();

?>
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

