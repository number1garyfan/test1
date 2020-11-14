<?php

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
require '/var/www/html/testen/composer/vendor/autoload.php';

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of EmailHelper
 *
 * @author pheeb
 */
class EmailHelper {
    
    function generate_email_otp()
    {
      try{
          $otp = mt_rand(10000000,99999999);
          return $otp; 
        } catch (Exception $ex) {

        }
    }
    
    function generate_otp_email($email, $otp)
    {
      try{

        //Create a new PHPMailer instance
        $mail = new PHPMailer();

        //Tell PHPMailer to use SMTP
        $mail->isSMTP();
        
        //Set the hostname of the mail server
        $mail->Host = 'smtp.gmail.com';
        // use
        // $mail->Host = gethostbyname('smtp.gmail.com');
        // if your network does not support SMTP over IPv6
        
        //Set the SMTP port number - 587 for authenticated TLS, a.k.a. RFC4409 SMTP submission
        $mail->Port = 587;

        //Set the encryption mechanism to use - STARTTLS or SMTPS
        $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;

        //Whether to use SMTP authentication
        $mail->SMTPAuth = true;
        
        //Username to use for SMTP authentication - use full email address for gmail
        $mail->Username = 'busbly12345@gmail.com';

        //Password to use for SMTP authentication
        $mail->Password = 'Haha1234';

        //Set who the message is to be sent from
        $mail->setFrom('busbly12345@gmail.com', 'Busbly Crews');

        //Set an alternative reply-to address
        $mail->addReplyTo('replyto@example.com', 'Busbly Crews');

        //Set who the message is to be sent to
        $mail->addAddress($email, 'John Doe');

        //Set the subject line
        $mail->Subject = 'PHPMailer GMail SMTP test';

        //Send HTML or Plain Text email
        $mail->isHTML(true);
        
        //Setup Mail Content
        $mail->Subject = "OTP for Busbly Login";
        $mail->Body = "<p> Here is your OTP for login, it will expires within 5 minutes</p><p>$otp</p>";
        $mail->AltBody = "This is the plain text version of the email content";
        

        //Replace the plain text body with one created manually
        $mail->AltBody = 'This is a plain-text message body';

        //send the message, check for errors
        if (!$mail->send()) {
            echo 'Mailer Error: ' . $mail->ErrorInfo;
            return $mail;
        } else {
            echo '<script type="text/javascript">
            window.onload = function () { alert("OTP Email has been sent!"); }
            </script>';
            return $mail;
        }

        } catch (Exception $ex) {

        }
    }
    
    function generate_activation_email($email, $activationID)
    {
      try{

        //Create a new PHPMailer instance
        $mail = new PHPMailer();

        //Tell PHPMailer to use SMTP
        $mail->isSMTP();
        
        //Set the hostname of the mail server
        $mail->Host = 'smtp.gmail.com';
        // use
        // $mail->Host = gethostbyname('smtp.gmail.com');
        // if your network does not support SMTP over IPv6
        
        //Set the SMTP port number - 587 for authenticated TLS, a.k.a. RFC4409 SMTP submission
        $mail->Port = 587;

        //Set the encryption mechanism to use - STARTTLS or SMTPS
        $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;

        //Whether to use SMTP authentication
        $mail->SMTPAuth = true;
        
        //Username to use for SMTP authentication - use full email address for gmail
        $mail->Username = 'busbly12345@gmail.com';

        //Password to use for SMTP authentication
        $mail->Password = 'Haha1234';

        //Set who the message is to be sent from
        $mail->setFrom('busbly12345@gmail.com', 'Busbly Crews');

        //Set an alternative reply-to address
        $mail->addReplyTo('replyto@example.com', 'Busbly Crews');

        //Set who the message is to be sent to
        $mail->addAddress($email, 'John Doe');

        //Set the subject line
        $mail->Subject = 'PHPMailer GMail SMTP test';

        //Send HTML or Plain Text email
        $mail->isHTML(true);
        
        //Setup Mail Content
        $actual_link = "https://teamname.sitict.net/testen/accountActivation.php?id=" . $activationID;
        $mail->Subject = "Account Activation for Busbly Registration";
        $mail->Body = "<p>Thank you for signing up with us!</p><p>Click this link to activate your account. <a href='" . $actual_link . "'>" . $actual_link . "</a></p>";
        $mail->AltBody = "This is the plain text version of the email content";
        

        //Replace the plain text body with one created manually
        $mail->AltBody = 'This is a plain-text message body';

        //send the message, check for errors
        if (!$mail->send()) {
            echo 'Mailer Error: ' . $mail->ErrorInfo;
            return $mail;
        } else {
            echo '<script type="text/javascript">
            window.onload = function () { alert("Account Activation Email has been sent!"); }
            </script>';
            return $mail;
        }

        } catch (Exception $ex) {

        }
    }
    
    function generate_forget_password_email($email, $otp)
    {
      try{

        //Create a new PHPMailer instance
        $mail = new PHPMailer();

        //Tell PHPMailer to use SMTP
        $mail->isSMTP();
        
        //Set the hostname of the mail server
        $mail->Host = 'smtp.gmail.com';
        // use
        // $mail->Host = gethostbyname('smtp.gmail.com');
        // if your network does not support SMTP over IPv6
        
        //Set the SMTP port number - 587 for authenticated TLS, a.k.a. RFC4409 SMTP submission
        $mail->Port = 587;

        //Set the encryption mechanism to use - STARTTLS or SMTPS
        $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;

        //Whether to use SMTP authentication
        $mail->SMTPAuth = true;
        
        //Username to use for SMTP authentication - use full email address for gmail
        $mail->Username = 'busbly12345@gmail.com';

        //Password to use for SMTP authentication
        $mail->Password = 'Haha1234';

        //Set who the message is to be sent from
        $mail->setFrom('busbly12345@gmail.com', 'Busbly Crews');

        //Set an alternative reply-to address
        $mail->addReplyTo('replyto@example.com', 'Busbly Crews');

        //Set who the message is to be sent to
        $mail->addAddress($email, 'John Doe');

        //Set the subject line
        $mail->Subject = 'PHPMailer GMail SMTP test';

        //Send HTML or Plain Text email
        $mail->isHTML(true);
        
        //Setup Mail Content
        $actual_link = "https://teamname.sitict.net/testen/accountActivation.php?id=" . $activationID;
        $mail->Subject = "Forget Password OTP for Busbly";
        $mail->Body = "<p> Here is your OTP for Forget Password, it will expires within 5 minutes</p><p>$otp</p>";
        $mail->AltBody = "This is the plain text version of the email content";
        

        //Replace the plain text body with one created manually
        $mail->AltBody = 'This is a plain-text message body';

        //send the message, check for errors
        if (!$mail->send()) {
            echo 'Mailer Error: ' . $mail->ErrorInfo;
            return $mail;
        } else {
            echo '<script type="text/javascript">
            window.onload = function () { alert("Account Activation Email has been sent!"); }
            </script>';
            return $mail;
        }

        } catch (Exception $ex) {

        }
    }
            
    
    //Section 2: IMAP
    //IMAP commands requires the PHP IMAP Extension, found at: https://php.net/manual/en/imap.setup.php
    //Function to call which uses the PHP imap_*() functions to save messages: https://php.net/manual/en/book.imap.php
    //You can use imap_getmailboxes($imapStream, '/imap/ssl', '*' ) to get a list of available folders or labels, this can
    //be useful if you are trying to get this working on a non-Gmail IMAP server.
    function save_mail($mail)
    {
        //You can change 'Sent Mail' to any other folder or tag
        $path = '{imap.gmail.com:993/imap/ssl}[Gmail]/Sent Mail';

//        //Tell your server to open an IMAP connection using the same username and password as you used for SMTP
//        $imapStream = imap_open($path, $mail->Username, $mail->Password);
//
//        $result = imap_append($imapStream, $path, $mail->getSentMIMEMessage());
//        imap_close($imapStream);

        return "";
    }
    
}
