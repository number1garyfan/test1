<?php
    function getAccountDetailsForUpdate($email, $mysqli)
    {
        try{
            $stmt = $mysqli->prepare("SELECT Email, Username, Password FROM Account WHERE Email = ? LIMIT 1");
            $stmt->bind_param("s", $email); // Bind param $userid to query parameter (?)
            $stmt->execute(); // Execute the prepared query
            $result = $stmt->get_result();
            $stmt -> close();
        
            return $result;
        }catch(Exception $e) {
           
        }
    }
    
    function updateProfile($email, $username, $password, $salt, $mysqli)
    {
        try{
            $stmt = $mysqli->prepare("UPDATE Account SET Email = ?, Username = ?, Password = ?, Salt = ? WHERE Email = ?");
            $stmt->bind_param("sssss", $email, $username, $password, $salt, $email); // Bind param $userid to query parameter (?)
            $stmt->execute(); // Execute the prepared query
            $stmt -> close();
            
        }catch(Exception $e) {
   
        }
    }
    
    function updateProfileWithoutSalt($email, $username, $password, $mysqli)
    {
        try{
            $stmt = $mysqli->prepare("UPDATE Account SET Email = ?, Username = ?, Password = ? WHERE Email = ?");
            $stmt->bind_param("ssss", $email, $username, $password, $email); // Bind param $userid to query parameter (?)
            $stmt->execute(); // Execute the prepared query
            $stmt -> close();
            
        }catch(Exception $e) {
   
        }
    }
    
    //For Registration
    function checkUserExist($username, $mysqli)
    {
        try{
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
            
        }catch(Exception $e) {
   
        }
    }
    
    //For Registration
    function checkEmailExist($email, $mysqli)
    {
        try{
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
            
        }catch(Exception $e) {
   
        }
    }
    
    //For Registration
    function insertUser($username, $password, $salt, $email, $roleID, $activationID, $mysqli)
    {
        try{
        $stmt = $mysqli->prepare ("INSERT INTO Account (Username, Password, Salt, CreationDate, Email, ActivationID, Roles_idRoles) VALUES (?, ?, ?, NOW(), ?, ?, ?)");
        $stmt->bind_param("sssssi", $username, $password, $salt, $email, $activationID, $roleID); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    

    function login($email, $mysqli)
    {
        try{
        $stmt = $mysqli->prepare("UPDATE Account SET LastLogin = NOW(), FailLoginCount = 0, Sessions = 1 WHERE Email = ? ");
        $stmt->bind_param("s", $email); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
          
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function account_activation($activationCode, $mysqli)
    {
        try{
        $stmt = $mysqli->prepare("UPDATE Account SET Verified = 1 WHERE ActivationID = ?");
        $stmt->bind_param("s", $activationCode); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function store_otp($otp, $email, $mysqli)
    {
        try{
        $stmt = $mysqli->prepare ("INSERT INTO OTP (OneTimePassword, StartTime, Account_Id, ValidationOTP) VALUES (?, NOW(), (SELECT idAccount from Account WHERE Email = ?), 1)");
        $stmt->bind_param("ss", $otp, $email); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
       
    function checkValidOTP($otp, $mysqli)
    {
        try{
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
            
        }catch(Exception $e) {
   
        }
    }
    
    function checkOTPExpired($otp, $mysqli)
    {
        try{
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
            
        }catch(Exception $e) {
   
        }
    }
    
    function checkUsedOTP($otp, $mysqli)
    {
        try{
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
            
        }catch(Exception $e) {
   
        }
    }
    
    // Delete OTP from table once used
    function update_otp($otp, $mysqli)
    {
        try{
        $stmt = $mysqli->prepare("UPDATE OTP SET ValidationOTP = 0 WHERE OneTimePassword = ? "); 
        $stmt->bind_param("i", $otp); 
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
        //Retrieve variables for sessions
    function populate_session_variables($email, $mysqli)
    {
        try{
        $stmt = $mysqli->prepare("SELECT idAccount, Email, Username, Roles_idRoles FROM Account WHERE Email = ? LIMIT 1");
        $stmt->bind_param("s", $email); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt->store_result();
        $stmt->bind_result($db_accountid,$db_email,$db_username,$db_roles); // Get variables from result
        $stmt->fetch();
        if ($stmt->num_rows == 1)
        {	
                $_SESSION['AccountId'] = $db_accountid;
                $_SESSION["Roles"] = $db_roles;
                $_SESSION["Username"] = $db_username;
                $_SESSION["Email"] = $db_email;
                            
                $stmt->close();
                return true;
        } else {
                $stmt->close();
                return false;
        }
            }catch(Exception $e) {
   
        }
    }
    
    //Retrieve the salt
    function get_salt($email, $mysqli)
    {
        try{
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
        
        }catch(Exception $e) {
   
        }
    }

    // Brute force attacks prevention, lock an account if a user has a failed login more than 3 times
    function checkbrute($db_email, $mysqli) {
        try{
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
            
        }catch(Exception $e) {
   
        }
    }
    
    
    // If attempt is considered brute force, start 30mins timer, 30mins end, reset brute force counts
    function set_brute_force_counter($db_email, $mysqli) {
        try{
        $str=rand(); 
        $randomResult = md5($str);
        $event_name = $randomResult;
        
        $stmt = "CREATE EVENT $event_name ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL 60 second DO UPDATE Account SET FailLoginCount = 0 WHERE Email = '$db_email' "; 
        $mysqli->query($stmt);
        $mysqli->close();
        
        }catch(Exception $e) {
   
        }
    }
    
   
    
 // Check userid and password against the database
    // XSS protection
    // Using prepared statements means that SQL injection is not possible
    function check_login($email, $password, $mysqli) {
        try{
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
                            return true;
                        }
                }

        } else {
            //No user exists
            $stmt->close();
	    return false;
        }
        
        }catch(Exception $e) {
         
        }
    }
    
    function reset_password($password, $salt, $email, $mysqli)
    {
        try{
        $stmt = $mysqli->prepare("UPDATE Account SET Password = ?, Salt = ? WHERE Email = ?");
        $stmt->bind_param("sss", $password, $salt, $email); // Bind param $userid to query parameter (?)
        $stmt->execute(); // Execute the prepared query
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function read_topic($mysqli)
    {
        try{
        $stmt = $mysqli->prepare("SELECT idTopic,TopicTitle,count(distinct idThread) as ThreadNo,count(distinct idPost) as PostNo,tp.Created_By_AccountId FROM Topic tp LEFT JOIN Thread td ON td.deleted <> 1 or td.deleted is null and tp.idTopic = td.Topic_idTopic LEFT JOIN Post p ON p.deleted <> 1 or p.deleted is null and p.Thread_idThread = td.idThread WHERE tp.deleted <> 1 or tp.deleted is null GROUP BY idTopic;");
        $stmt->execute();
        $result = $stmt->get_result();
        $stmt -> close();
        
        return $result;
        
        }catch(Exception $e) {
   
        }
    }
    
    function read_thread($topicid,$mysqli)
    {
        try{
        $stmt = $mysqli->prepare("SELECT idThread, ThreadTitle ,count(distinct idPost) as PostNo,td.Created_By_AccountId FROM Topic tp , Thread td left join Post p on p.deleted <> 1 or p.deleted is null and p.Thread_idThread = td.idThread where td.deleted <> 1 or td.deleted is null and tp.idTopic = td.Topic_idTopic and idTopic = ? GROUP BY idThread;");
        $stmt->bind_param("i", $topicid);
        $stmt->execute();
        $result = $stmt->get_result();
        $stmt -> close();
        
        return $result;
        
        }catch(Exception $e) {
   
        }
    }
    
    function read_post($threadid,$mysqli)
    {
        try{
        $stmt = $mysqli->prepare("SELECT idPost, CommentPost, Username , p.Created_By_AccountId FROM Thread td, Post p,Account a where p.deleted <> 1 or p.deleted is null and p.Thread_idThread = td.idThread and a.idAccount = p.Created_By_AccountId and idThread = ? ;");
        $stmt->bind_param("i", $threadid);
        $stmt->execute();
        $result = $stmt->get_result();
        $stmt -> close();
        
        return $result;
        
        }catch(Exception $e) {
   
        }
    }
    
    function insert_topic($TopicName,$accountID,$mysqli)
    {
        try{
        $stmt = $mysqli->prepare("insert into Topic (TopicTitle,CreationDate,Created_By_AccountId) Values (?,NOW(),?);");
        $stmt->bind_param("si", $TopicName,$accountID);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function insert_thread($ThreadName,$accountID,$topicid,$mysqli)
    {
        try{
        $stmt = $mysqli->prepare("INSERT INTO Thread (ThreadTitle,CreationDate,Created_By_AccountId,Topic_idTopic) Values (?,NOW(),?,?);");
        $stmt->bind_param("sii", $ThreadName,$accountID,$topicid); 
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function insert_post($Postcomment,$accountID,$threadid,$mysqli)
    {
        try{
        $stmt = $mysqli->prepare("insert into Post(CommentPost, CreationDate,Created_By_AccountId,Thread_idThread) Values (?,NOW(),?,?);");
        $stmt->bind_param("sii", $Postcomment,$accountID,$threadid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function update_topic($TopicName,$Topicid,$accountID,$roles,$mysqli){
        try{
        $stmt = $mysqli->prepare("SELECT Created_By_AccountId FROM Topic where idTopic = ? ;");
        $stmt->bind_param("i", $Topicid);
        $stmt->execute();
        $stmt->store_result();
        $stmt->bind_result($db_createdByAccountId); // Get variables from result
        $stmt->fetch();
        
        if ($stmt->num_rows == 1) {
            //admin
            if($roles == 1){
                $stmt = $mysqli->prepare("UPDATE Topic SET TopicTitle = ? WHERE idTopic = ?");
                $stmt->bind_param("si", $TopicName,$Topicid);
                if ($stmt->execute()){
                    return true;
                }else{
                    return false;
                }
                }
            //owner of topic
            else if($db_createdByAccountId == $accountID){
                $stmt = $mysqli->prepare("UPDATE Topic SET TopicTitle = ? WHERE idTopic = ?");
                $stmt->bind_param("si", $TopicName,$Topicid);
                if ($stmt->execute()){
                    return true;
                }else{
                    return false;
                }
            }
            else{
                return false;    
            }
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
        
    }
    
    function update_thread($ThreadName,$threadid,$accountID,$roles,$mysqli){
        try{
        $stmt = $mysqli->prepare("SELECT Created_By_AccountId FROM Thread where idThread = ? ;");
        $stmt->bind_param("i", $threadid);
        $stmt->execute();
        $stmt->store_result();
        $stmt->bind_result($db_createdByAccountId); // Get variables from result
        $stmt->fetch();
        
        
        if ($stmt->num_rows == 1) {
            //admin
            if($roles == 1){
                $stmt = $mysqli->prepare("UPDATE Thread SET ThreadTitle = ? Where idThread = ?;");
                $stmt->bind_param("si", $ThreadName,$threadid);
                if ($stmt->execute()){
                    return true;
                }else{
                    return false;
                }
                }
            //owner of topic
            else if($db_createdByAccountId == $accountID){
                $stmt = $mysqli->prepare("UPDATE Thread SET ThreadTitle = ? Where idThread = ?;");
                $stmt->bind_param("si", $ThreadName,$threadid);
                if ($stmt->execute()){
                    return true;
                }else{
                    return false;
                }
            }
            else{
                return false;    
            }
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }

    }
    
    function update_post($PostComment,$postid,$accountID,$roles,$mysqli){
        try{
        $stmt = $mysqli->prepare("SELECT Created_By_AccountId FROM Post where idPost = ? ;");
        $stmt->bind_param("i", $postid);
        $stmt->execute();
        $stmt->store_result();
        $stmt->bind_result($db_createdByAccountId); // Get variables from result
        $stmt->fetch();
        
        if ($stmt->num_rows == 1) {
            //admin
            if($roles == 1){
                $stmt = $mysqli->prepare("UPDATE Post SET CommentPost = ? Where idPost = ?;");
                $stmt->bind_param("si", $PostComment,$postid);
                if ($stmt->execute()){
                    return true;
                }else{
                    return false;
                }
                }
            //owner of topic
            else if($db_createdByAccountId == $accountID){
                $stmt = $mysqli->prepare("UPDATE Post SET CommentPost = ? Where idPost = ?;");
                $stmt->bind_param("si", $PostComment,$postid);
                if ($stmt->execute()){
                    return true;
                }else{
                    return false;
                }
            }
            else{
                return false;    
            }
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function delete_topic($accountID,$topicid,$roles,$mysqli)
    {   
        try{
        $stmt = $mysqli->prepare("SELECT Created_By_AccountId FROM Topic where idTopic = ? ;");
        $stmt->bind_param("i", $topicid);
        $stmt->execute();
        $stmt->store_result();
        $stmt->bind_result($db_createdByAccountId); // Get variables from result
        $stmt->fetch();
        
        if ($stmt->num_rows == 1) {
            //admin
            if($roles == 1){
                $stmt = $mysqli->prepare("UPDATE Topic tp left join Thread td On tp.idTopic = td.Topic_idTopic left join Post p on td.idThread = p.Thread_idThread Set tp.Deleted = true,tp.DeletionDate = Now(),tp.Deleted_By_AccountId = ? , td.Deleted = true,td.DeletionDate = Now(),td.Deleted_By_AccountId = ? ,p.Deleted = true,p.DeletionDate = Now(),p.Deleted_By_AccountId = ? where tp.idTopic = ? ;");
                $stmt->bind_param("iiii", $accountID,$accountID,$accountID,$topicid);
                    if($stmt->execute()){
                        return true;
                    }else{
                        return false;
                    }
                }
            //owner of topic
            else if($db_createdByAccountId == $accountID){
                    $stmt = $mysqli->prepare("UPDATE Topic tp left join Thread td On tp.idTopic = td.Topic_idTopic left join Post p on td.idThread = p.Thread_idThread Set tp.Deleted = true,tp.DeletionDate = Now(),tp.Deleted_By_AccountId = ? , td.Deleted = true,td.DeletionDate = Now(),td.Deleted_By_AccountId = ? ,p.Deleted = true,p.DeletionDate = Now(),p.Deleted_By_AccountId = ? where tp.idTopic = ? ;");
                    $stmt->bind_param("iiii", $accountID,$accountID,$accountID,$topicid);
                        if($stmt->execute()){
                            return true;
                        }else{
                            return false;
                        }
            }
            else{
                return false;    
            }
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function delete_thread($accountID,$threadid,$roles,$mysqli)
    {      
        try{
        $stmt = $mysqli->prepare("SELECT Created_By_AccountId FROM Thread where idThread = ? ;");
        $stmt->bind_param("i", $threadid);
        $stmt->execute();
        $stmt->store_result();
        $stmt->bind_result($db_createdByAccountId); // Get variables from result
        $stmt->fetch();
        
        if ($stmt->num_rows == 1) {
            //admin
            if($roles == 1){
                    $stmt = $mysqli->prepare("UPDATE Thread td left join  Post p on td.idThread = p.Thread_idThread SET td.Deleted = true,td.DeletionDate = Now(),td.Deleted_By_AccountId = ? ,p.Deleted = true,p.DeletionDate = Now(),p.Deleted_By_AccountId = ? where td.idThread = ? ;");
                    $stmt->bind_param("iii", $accountID,$accountID,$threadid);
                    if($stmt->execute()){
                        return true;
                    }else{
                        return false;
                    }
                }
            //owner of thread
            else if($db_createdByAccountId == $accountID){
                    $stmt = $mysqli->prepare("UPDATE Thread td left join  Post p on td.idThread = p.Thread_idThread SET td.Deleted = true,td.DeletionDate = Now(),td.Deleted_By_AccountId = ? ,p.Deleted = true,p.DeletionDate = Now(),p.Deleted_By_AccountId = ? where td.idThread = ? ;");
                    $stmt->bind_param("iii", $accountID,$accountID,$threadid);
                    if($stmt->execute()){
                        return true;
                    }else{
                        return false;
                    }
            }
            else{
                return false;    
            }
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
        
    }
    
    function delete_post($accountID,$postid,$roles,$mysqli)
    {   
        try{
        $stmt = $mysqli->prepare("SELECT Created_By_AccountId FROM Post where idPost = ? ;");
        $stmt->bind_param("i", $postid);
        $stmt->execute();
        $stmt->store_result();
        $stmt->bind_result($db_createdByAccountId); // Get variables from result
        $stmt->fetch();
        
        if ($stmt->num_rows == 1) {
            //admin
            if($roles == 1){
                    $stmt = $mysqli->prepare("UPDATE Post SET Deleted = true,DeletionDate = Now(),Deleted_By_AccountId = ? Where idPost = ? ;");
                    $stmt->bind_param("ii", $accountID,$postid);
                    if ($stmt->execute()){
                        return true;
                    }else{
                        return false;
                    }
                }
            //owner of post
            else if($db_createdByAccountId == $accountID){
                $stmt = $mysqli->prepare("UPDATE Post SET Deleted = true,DeletionDate = Now(),Deleted_By_AccountId = ? Where idPost = ? ;");
                $stmt->bind_param("ii", $accountID,$postid);
                if ($stmt->execute()){
                    return true;
                }else{
                    return false;
                }
            }
            else{
                return false;    
            }
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
        
    }
    
    function report_thread($accountid,$mysqli)
    {
        try{
        $stmt = $mysqli->prepare("UPDATE Account Set ReportCounter = ReportCounter + 1 Where idAccount = ? ;");
        $stmt->bind_param("i", $accountid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function report_post($accountid,$mysqli)
    {
        try{
        $stmt = $mysqli->prepare("UPDATE Account Set ReportCounter = ReportCounter + 1 Where idAccount = ? ;");
        $stmt->bind_param("i", $accountid);
        if ($stmt->execute()){
            return true;
        }else{
            return false;
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function read_user($mysqli)
    {
        try{
        $stmt = $mysqli->prepare("SELECT idAccount,Username,Roles,Banned,ReportCounter FROM Account a, Roles r Where a.Roles_idRoles = r.idRoles;");
        $stmt->execute();
        $result = $stmt->get_result();
        $stmt -> close();
        
        return $result;
        
        }catch(Exception $e) {
   
        }
    }
    
    function promote_user_admin($accountid,$roles,$mysqli){
        try{
        //admin
        if($roles == 1){
            $stmt = $mysqli->prepare("UPDATE Account SET Roles_idRoles = 1 Where idAccount = ? ;");
            $stmt->bind_param("i", $accountid);
            if ($stmt->execute()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function promote_user_mod($accountid,$roles,$mysqli){
        try{
        //admin
        if($roles == 1){
            $stmt = $mysqli->prepare("UPDATE Account SET Roles_idRoles = 4 Where idAccount = ? ;");
            $stmt->bind_param("i", $accountid);
            if ($stmt->execute()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function demote_user_user($accountid,$roles,$mysqli){
        try{
        //admin
        if($roles == 1){
            $stmt = $mysqli->prepare("UPDATE Account SET Roles_idRoles = 2 Where idAccount = ? ;");
            $stmt->bind_param("i", $accountid);
            if ($stmt->execute()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function ban_user($accountid,$roles,$mysqli){
        try{
        //admin
        if($roles == 1){
            $stmt = $mysqli->prepare("UPDATE Account SET Banned = 1 Where idAccount = ? ;");
            $stmt->bind_param("i", $accountid);
            if ($stmt->execute()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
        function unban_user($accountid,$roles,$mysqli){
        try{
        //admin
        if($roles == 1){
            $stmt = $mysqli->prepare("UPDATE Account SET Banned = 0 Where idAccount = ? ;");
            $stmt->bind_param("i", $accountid);
            if ($stmt->execute()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function logout_user($accountid,$mysqli){
        try{
        $stmt = $mysqli->prepare("UPDATE Account SET Sessions = 0 Where idAccount = ? ;");
        $stmt->bind_param("i", $accountid);
        $stmt->execute();
        $stmt -> close();
        
        }catch(Exception $e) {
   
        }
    }
    
    function view_profile_thread($accountid,$mysqli){
        try{
        $stmt = $mysqli->prepare("SELECT idThread, ThreadTitle,Created_By_AccountId From Thread where deleted <> 1 or deleted is null and Created_By_AccountId = ?;");
        $stmt->bind_param("i", $accountid);
        $stmt->execute();
        $result = $stmt->get_result();
        $stmt -> close();
        
        return $result;
        
         }catch(Exception $e) {
   
        }
    }
    
    function view_profile_post($accountid,$mysqli){
        try{
        $stmt = $mysqli->prepare("SELECT idPost, CommentPost,Created_By_AccountId From Post where deleted <> 1 or deleted is null and Created_By_AccountId = ?;");
        $stmt->bind_param("i", $accountid);
        $stmt->execute();
        $result = $stmt->get_result();
        $stmt -> close();
        
        return $result;
        
        }catch(Exception $e) {
   
        }
    }
    

    
?>

