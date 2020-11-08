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
        $stmt = $mysqli->prepare ("INSERT INTO Account (Username, Password, Salt, CreationDate, Email, ActivationID, Roles_idRoles) VALUES (?, ?, ?, NOW(), ?, ?, ?)");
        $stmt->bind_param("sssssi", $username, $password, $salt, $email, $activationID, $roleID); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
    }
    

    function login($email, $mysqli)
    {
        $stmt = $mysqli->prepare("UPDATE Account SET LastLogin = NOW(), FailLoginCount = 0, Sessions = 1 WHERE Email = ? ");
        $stmt->bind_param("s", $email); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
    }
    
    function account_activation($activationCode, $mysqli)
    {
        $stmt = $mysqli->prepare("UPDATE Account SET Verified = 1 WHERE ActivationID = ?");
        $stmt->bind_param("s", $activationCode); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
    }
    
    function store_otp($otp, $email, $mysqli)
    {
        $stmt = $mysqli->prepare ("INSERT INTO OTP (OneTimePassword, StartTime, Account_Id, ValidationOTP) VALUES (?, NOW(), (SELECT idAccount from Account WHERE Email = ?), 1)");
        $stmt->bind_param("ss", $otp, $email); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
    }
       
    function checkValidOTP($otp, $mysqli)
    {
            $stmt = $mysqli->prepare("SELECT OneTimePassword FROM OTP WHERE OneTimePassword = ? LIMIT 1");
            $stmt->bind_param("i", $otp); // Bind param $userid to query parameter (?)
            $stmt->execute(); // Execute the prepared query
            $stmt->store_result();
            $stmt->bind_result($db_otp); // Get variables from result
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
    
    function checkOTPExpired($otp, $mysqli)
    {
            $stmt = $mysqli->prepare("SELECT OneTimePassword FROM OTP WHERE OneTimePassword = ? AND NOW()>DATE_ADD(StartTime, INTERVAL 5 MINUTE) LIMIT 1");
            $stmt->bind_param("i", $otp); // Bind param $userid to query parameter (?)
            $stmt->execute(); // Execute the prepared query
            $stmt->store_result();
            $stmt->bind_result($db_start_time); // Get variables from result
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
    
    function checkUsedOTP($otp, $mysqli)
    {
            $stmt = $mysqli->prepare("SELECT ValidationOTP FROM OTP WHERE OneTimePassword = ? AND ValidationOTP = 0 LIMIT 1");
            $stmt->bind_param("i", $otp); // Bind param $userid to query parameter (?)
            $stmt->execute(); // Execute the prepared query
            $stmt->store_result();
            $stmt->bind_result($db_start_time); // Get variables from result
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
    
    // Delete OTP from table once used
    function update_otp($otp, $mysqli)
    {
        $stmt = $mysqli->prepare("UPDATE OTP SET ValidationOTP = 0 WHERE OneTimePassword = ? "); 
        $stmt->bind_param("i", $otp); 
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
    }
    
   

     // Start a php session in a secure way
    // Prevent XSS attack and session hijacking
    function sec_session_start()
    {
//            $session_name = "sec_session_id"; // Set a custom session name, rename for every new project
//            $secure = false; // set to true if using https
//            $httponly = true; // This stop javascript being able to access the session id
//
//            ini_set("session.use_only_cookies", 1); // Forces sessions to only use cookies
//            ini_set("session.cookie_lifetime", 60 * 60 * 0.15); //15minutes Life time
//
//            $cookieParams = session_get_cookie_params(); // Gets current cookies param
//
//            session_set_cookie_params($cookieParams["lifetime"], $cookieParams["path"], $cookieParams["domain"], $secure, $httponly);
//            session_name($session_name); // Sets the session name to the one above
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

            $stmt = $mysqli->prepare("SELECT FailLoginCount FROM Account WHERE Email = ? AND FailLoginCount IS NOT NULL");
            $stmt->bind_param("s", $db_email);
            $stmt->execute();
            $stmt->store_result();
            $stmt->bind_result($wot);
            $stmt->fetch();

            // If there has been more than 3 failed login from the past 1 hour
            if ($wot > 3) {
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
        $mysqli->query($stmt);
        $mysqli->close();
    }
    
   
    
 // Check userid and password against the database
    // XSS protection
    // Using prepared statements means that SQL injection is not possible
    function check_login($email, $password, $mysqli) {
        $stmt = $mysqli->prepare("SELECT idAccount,Username, Password, Salt, Sessions, FailLoginCount, Email, Roles_idRoles, Verified,Banned FROM Account WHERE Email = ? LIMIT 1"); 
        $stmt->bind_param("s", $email); // Bind param $email to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt->store_result();
        $stmt->bind_result($db_accountid,$db_username, $db_password, $db_salt, $db_sessions, $db_failedLoginCount, $db_email, $db_roles, $db_verified, $db_banned); // Get variables from result
        $stmt->fetch();
        // If user exists
        if ($stmt->num_rows == 1) {
                // Check if account is locked from too many login attempts
                if (checkbrute($db_email, $mysqli) == true) {
                        // Account is locked
                        //$stmt->close();
                        return false;
                } else {
                        // Check if password in database matches the password the user submitted                 
                        if ($db_password != $password) {
                            // Password is not correct, we record this attempt in the database
                            if($db_failedLoginCount >= 0){
                                $value = $db_failedLoginCount + 1;
                                $stmt = $mysqli->prepare("UPDATE Account SET FailLoginCount = ? WHERE Email = ?");
                                $stmt->bind_param('is', $value, $email);
                                $stmt->execute();
                                $stmt->close();
                            }
                            else{
                                $value = 0;
                                $stmt = $mysqli->prepare("UPDATE Account SET FailLoginCount = ? WHERE Email = ?");
                                $stmt->bind_param('is', $value, $email);
                                $stmt->execute();
                                $stmt->close();
                            }
                            set_brute_force_counter($db_email, $mysqli);
                            return false;

                        } 
                        else if($db_verified != 1){
                            return false;
                        }
                        else if($db_sessions == 1){
                            //There's concurrent login
                            return false;
                        }
                        else if($db_failedLoginCount >= 3){
                            //Account is locked 
                            return false;
                        }
                        else if($db_banned == 1){
                            //Account is banned
                            return false;
                        }
                        else {
                            //Store DB variables to Session Variables
                            $_SESSION['AccountId'] = $db_accountid;
                            $_SESSION["Roles"] = $db_roles;
                            $_SESSION["Username"] = $db_username;
                            $_SESSION["Email"] = $db_email;
                            return true;
                        }
                }

        } else {
            //No user exists
            $stmt->close();
	    return false;
        }
    }
    
    function reset_password($password, $salt, $email, $mysqli)
    {
        $stmt = $mysqli->prepare("UPDATE Account SET Password = ?, Salt = ? WHERE Email = ?");
        $stmt->bind_param("sss", $password, $salt, $email); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
    }
    
    function read_topic($mysqli)
    {
        $stmt = $mysqli->prepare("SELECT idTopic,TopicTitle,count(distinct idThread) as ThreadNo,count(distinct idPost) as PostNo,tp.Created_By_AccountId FROM Topic tp LEFT JOIN Thread td ON td.deleted <> 1 or td.deleted is null and tp.idTopic = td.Topic_idTopic LEFT JOIN Post p ON p.deleted <> 1 or p.deleted is null and p.Thread_idThread = td.idThread WHERE tp.deleted <> 1 or tp.deleted is null GROUP BY idTopic;");
        $stmt->execute();
        $result = $stmt->get_result();
        $stmt -> close();
        
        return $result;
    }
    
    function read_thread($topicid,$mysqli)
    {
        $stmt = $mysqli->prepare("SELECT idThread, ThreadTitle ,count(distinct idPost) as PostNo,td.Created_By_AccountId FROM Topic tp , Thread td left join Post p on p.deleted <> 1 or p.deleted is null and p.Thread_idThread = td.idThread where td.deleted <> 1 or td.deleted is null and tp.idTopic = td.Topic_idTopic and idTopic = ? GROUP BY idThread;");
        $stmt->bind_param("i", $topicid);
        $stmt->execute();
        $result = $stmt->get_result();
        $stmt -> close();
        
        return $result;
    }
    
    function read_post($threadid,$mysqli)
    {
        $stmt = $mysqli->prepare("SELECT idPost, CommentPost, Username , p.Created_By_AccountId FROM Thread td, Post p,Account a where p.deleted <> 1 or p.deleted is null and p.Thread_idThread = td.idThread and a.idAccount = p.Created_By_AccountId and idThread = ? ;");
        $stmt->bind_param("i", $threadid);
        $stmt->execute();
        $result = $stmt->get_result();
        $stmt -> close();
        
        return $result;
    }
    
    function insert_topic($TopicName,$accountID,$mysqli)
    {
        $stmt = $mysqli->prepare("insert into Topic (TopicTitle,CreationDate,Created_By_AccountId) Values (?,NOW(),?);");
        $stmt->bind_param("si", $TopicName,$accountID);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function insert_thread($ThreadName,$accountID,$topicid,$mysqli)
    {
        $stmt = $mysqli->prepare("INSERT INTO Thread (ThreadTitle,CreationDate,Created_By_AccountId,Topic_idTopic) Values (?,NOW(),?,?);");
        $stmt->bind_param("sii", $ThreadName,$accountID,$topicid); 
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function insert_post($Postcomment,$accountID,$threadid,$mysqli)
    {
        $stmt = $mysqli->prepare("insert into Post(CommentPost, CreationDate,Created_By_AccountId,Thread_idThread) Values (?,NOW(),?,?);");
        $stmt->bind_param("sii", $Postcomment,$accountID,$threadid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function delete_topic($accountID,$topicid,$mysqli)
    {
        $stmt = $mysqli->prepare("UPDATE Topic tp left join Thread td On tp.idTopic = td.Topic_idTopic left join Post p on td.idThread = p.Thread_idThread Set tp.Deleted = true,tp.DeletionDate = Now(),tp.Deleted_By_AccountId = ? , td.Deleted = true,td.DeletionDate = Now(),td.Deleted_By_AccountId = ? ,p.Deleted = true,p.DeletionDate = Now(),p.Deleted_By_AccountId = ? where tp.idTopic = ? ;");
        $stmt->bind_param("iiii", $accountID,$accountID,$accountID,$topicid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function delete_thread($accountID,$threadid,$mysqli)
    {
        $stmt = $mysqli->prepare("UPDATE Thread td left join  Post p on td.idThread = p.Thread_idThread SET td.Deleted = true,td.DeletionDate = Now(),td.Deleted_By_AccountId = ? ,p.Deleted = true,p.DeletionDate = Now(),p.Deleted_By_AccountId = ? where td.idThread = ? ;");
        $stmt->bind_param("iii", $accountID,$accountID,$threadid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function delete_post($accountID,$postid,$mysqli)
    {   
        $stmt = $mysqli->prepare("UPDATE Post SET Deleted = true,DeletionDate = Now(),Deleted_By_AccountId = ? Where idPost = ? ;");
        $stmt->bind_param("ii", $accountID,$postid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function report_thread($accountid,$mysqli)
    {
        $stmt = $mysqli->prepare("UPDATE Account Set ReportCounter = ReportCounter + 1 Where idAccount = ? ;");
        $stmt->bind_param("i", $accountid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function report_post($accountid,$mysqli)
    {
        $stmt = $mysqli->prepare("UPDATE Account Set ReportCounter = ReportCounter + 1 Where idAccount = ? ;");
        $stmt->bind_param("i", $accountid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function read_user($mysqli)
    {
        $stmt = $mysqli->prepare("SELECT idAccount,Username,Roles,Banned,ReportCounter FROM Account a, Roles r Where a.Roles_idRoles = r.idRoles;");
        $stmt->execute();
        $result = $stmt->get_result();
        $stmt -> close();
        
        return $result;
    }
    
    function promote_user_admin($accountid,$mysqli){
        $stmt = $mysqli->prepare("UPDATE Account SET Roles_idRoles = 1 Where idAccount = ? ;");
        $stmt->bind_param("i", $accountid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function promote_user_mod($accountid,$mysqli){
        $stmt = $mysqli->prepare("UPDATE Account SET Roles_idRoles = 4 Where idAccount = ? ;");
        $stmt->bind_param("i", $accountid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function demote_user_user($accountid,$mysqli){
        $stmt = $mysqli->prepare("UPDATE Account SET Roles_idRoles = 2 Where idAccount = ? ;");
        $stmt->bind_param("i", $accountid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function ban_user($accountid,$mysqli){
        $stmt = $mysqli->prepare("UPDATE Account SET Banned = 1 Where idAccount = ? ;");
        $stmt->bind_param("i", $accountid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
        function unban_user($accountid,$mysqli){
        $stmt = $mysqli->prepare("UPDATE Account SET Banned = 0 Where idAccount = ? ;");
        $stmt->bind_param("i", $accountid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
    }
    
    function logout_user($accountid,$mysqli){
        $stmt = $mysqli->prepare("UPDATE Account SET Sessions = 0 Where idAccount = ? ;");
        $stmt->bind_param("i", $accountid);
        $stmt->execute();
        $stmt -> close();
    }
    
?>

