<?php

    //For Registration
    function checkUserExist($username, $mysqli)
    {
            $stmt = $mysqli->prepare("SELECT Username FROM Account WHERE Username = ? LIMIT 1");
            $stmt->bind_param("s", $username); // Bind param $userid to query parameter (?)
            $stmt->execute(); // Execute the prepared query
            $stmt->store_result();
            $stmt->bind_result($db_username); // Get variables from result
            $stmt->fetch();
            if ($stmt->num_rows == 1)
            {	
                    $stmt->close();
                    return true;
            } else {
                    $stmt->close();
                    return false;
            }
    }
    
    //For Registration
    function checkEmailExist($email, $mysqli)
    {
            $stmt = $mysqli->prepare("SELECT Email FROM Account WHERE Email = ? LIMIT 1");
            $stmt->bind_param("s", $email); // Bind param $userid to query parameter (?)
            $stmt->execute(); // Execute the prepared query
            $stmt->store_result();
            $stmt->bind_result($db_email); // Get variables from result
            $stmt->fetch();
            if ($stmt->num_rows == 1)
            {	
                    $stmt->close();
                    return true;
            } else {
                    $stmt->close();
                    return false;
            }
    }
    
    //For Registration
    function insertUser($username, $password, $salt, $email, $roleID, $activationID, $mysqli)
    {
        $stmt = $mysqli->prepare ("INSERT INTO Account (Username, Password, Salt, CreationDate, Sessions, Email, ActivationID, Roles_idRoles) VALUES (?, ?, ?, NOW(), 1, ?, ?, ?)");
        $stmt->bind_param("sssssi", $username, $password, $salt, $email, $activationID, $roleID); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
    }
    

    function login($email, $mysqli)
    {
        $stmt = $mysqli->prepare("UPDATE Account SET (LastLogin = NOW(), FailLoginCount = 0, LastAttemptedLogin = NOW()) WHERE Email = ?");
        $stmt->bind_param("s", $email); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
    }
    
    function account_activation($activationCode, $mysqli)
    {
        $stmt = $mysqli->prepare("UPDATE Account SET (Verified = 1) WHERE ActivationID = ?");
        $stmt->bind_param("s", $activationCode); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
    }
    
     // Start a php session in a secure way
    // Prevent XSS attack and session hijacking
    function sec_session_start()
    {
            $session_name = "sec_session_id"; // Set a custom session name, rename for every new project
            $secure = false; // set to true if using https
            $httponly = true; // This stop javascript being able to access the session id

            ini_set("session.use_only_cookies", 1); // Forces sessions to only use cookies
            ini_set("session.cookie_lifetime", 60 * 60 * 0.15); //15minutes Life time

            $cookieParams = session_get_cookie_params(); // Gets current cookies param

            session_set_cookie_params($cookieParams["lifetime"], $cookieParams["path"], $cookieParams["domain"], $secure, $httponly);
            session_name($session_name); // Sets the session name to the one above
            session_start(); // Start the php session
    }
    
    //Retrieve the salt
    function get_salt($email, $mysqli)
    {
        $stmt = $mysqli->prepare("SELECT Salt FROM Account WHERE Email = ? LIMIT 1");
        $stmt->bind_param("s", $email); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt->store_result();
        $stmt->bind_result($db_salt); // Get variables from result
        $stmt->fetch();
        if ($stmt->num_rows == 1)
        {	
                $stmt->close();
                return $db_salt;
        } else {
                $stmt->close();
                return "";
        }
    }

    // Brute force attacks prevention, lock an account if a user has a failed login more than 3 times
    function checkbrute($db_email, $mysqli) {
            $now = time(); // Get timestamp of current time
            $valid_attempts = $now - (1 * 60 * 30); // All login attempts from the past 30min

            $stmt = $mysqli->prepare("SELECT FailLoginCount FROM Account WHERE Email = ? AND LastLogin > '$valid_attempts' AND LastLogin IS NOT NULL AND FailLoginCount IS NOT NULL");
            $stmt->bind_param("s", $db_email);
            $stmt->execute();
            $stmt->store_result();
            $stmt->bind_result($wot);
            $stmt->fetch();

            // If there has been more than 3 failed login from the past 1 hour
            if ($stmt->num_rows > 3) {
                    $stmt->close();
                    return true;
            } else {
                    $stmt->close();
                    return false;
            }
    }
    
    
    // If attempt is considered brute force, start 30mins timer, 30mins end, reset brute force counts
    function set_brute_force_counter($db_email, $mysqli) {
        $str=rand(); 
        $randomResult = md5($str);
        $event_name = $randomResult;
        
        $stmt = "CREATE EVENT $event_name ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL 60 second DO UPDATE Account SET FailLoginCount = 0 WHERE Email = '$db_email' "; 
        //$mysqli->query($stmt);
        //$mysqli->close();
    }
    
    
    
    // Check userid and password against the database
    // XSS protection
    // Using prepared statements means that SQL injection is not possible
    function check_login($email, $password, $mysqli) {
        $stmt = $mysqli->prepare("SELECT Username, Password, Salt, Sessions, FailLoginCount, Email, Roles_idRoles, Verified FROM Account WHERE Email = ? LIMIT 1"); 
        $stmt->bind_param("s", $email); // Bind param $email to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt->store_result();
        $stmt->bind_result($db_username, $db_password, $db_salt, $db_sessions, $db_failedLoginCount, $db_email, $db_roles, $db_verified); // Get variables from result
        $stmt->fetch();
        // If user exists
        if ($stmt->num_rows == 1) {
                $password = password_verify($password,$db_password);
                // Check if account is locked from too many login attempts
                if (checkbrute($db_email, $mysqli) == true) {
                        // Account is locked
                        //$stmt->close();
                        return false;
                } else {
                        // Check if password in database matches the password the user submitted
                        if ($db_password == $password && $db_verified == '1') {
                            //Store DB variables to Session Variables
                            $_SESSION["Roles"] = $db_roles;
                            $_SESSION["Username"] = $db_username;
                            $_SESSION["Email"] = $db_email;
                            return true;
                        } 
                        else if($db_sessions == 1){
                            //There's concurrent login
                            return false;
                        }
                        else if($db_failedLoginCount >= 3){
                            //Account is locked 
                            return false;
                        }
                        else {
//                                // Password is not correct, we record this attempt in the database
//                                if ($stmt = $mysqli->prepare("UPDATE Account SET (FailLoginCount = ?, LastAttemptedLogin = NOW()) WHERE Email = ?")) {
//                                        $stmt->bind_param('ss', $db_failedLoginCount+1, $email);
//                                        $stmt->execute();
//                                        //$stmt->close();
//                                }
                                set_brute_force_counter($db_email, $mysqli);
                                return false;
                        }
                }

        } else {
            //No user exists
            $stmt->close();
	    return false;
        }
    }
    
?>

