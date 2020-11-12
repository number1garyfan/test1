
<?php
// question: how do we call this before we start the server, have php file ask for password?
// then pass the password down to the decryption of this?
// how are we throwing the api key to be used? throw it to variable to the php file where it calls the api key and activate it?
// will we only need to activate it once? 
// 




function pushDataToFile($data, $file)
{
    $fp = fopen($file, 'w') or die("Unable to open file!");
    fwrite($fp, $data);
    fclose($fp);
}

function encryptAPIKey($password)
{
    //print_r($argv);
    $apiKey = '6Lft5OAZAAAAAPyuMvPvtfme46pulkZGzj4nMsNC';
    
    $algo = 'sha256';
    $salt = openssl_random_pseudo_bytes(16);
    $iterations = 100000;
    $len = 50;

    //text files to store values
    $storeDataKeyFile = 'storeDataKey.txt';
    $storeAPIKeyfile = 'data.txt';
    $IVandTag = 'IVandTag.txt';
    $saltFile = 'salt.txt';


    // Using hash_pbkdf2 function 
    
    $DataKey = hash_pbkdf2($algo, $password, $salt, $iterations, $len);


    //store encryption and decryption keys into txt file
    pushDataToFile($DataKey, $storeDataKeyFile);
    echo "Encryption keys have been pushed into " . $storeDataKeyFile . "\n";

    //Encrypt API Key 
    $cipher = "aes-128-gcm";

    if (in_array($cipher, openssl_get_cipher_methods())) {

        $ivlen = openssl_cipher_iv_length($cipher);
        $iv = openssl_random_pseudo_bytes($ivlen) . PHP_EOL;
        $ciphertext = openssl_encrypt($apiKey, $cipher, $DataKey, $options = 0, $iv, $tag);
        echo "The encrypted API key value is: " . $ciphertext . "\n";
    }

    //store IV and tag and salt value in file
    pushDataToFile($salt, $saltFile);
    echo "Salt value has been pushed into " . $saltFile . "\n";

    pushDataToFile($iv, $IVandTag);
    echo "IV value has been pushed into " . $IVandTag . "\n";

    file_put_contents($IVandTag, $tag, FILE_APPEND);
    echo "Tag value has been pushed into " . $IVandTag . "\n";


    //store encrypted API key in file 
    pushDataToFile($ciphertext, $storeAPIKeyfile);
    echo "Encrypted API Key value has been pushed into " . $storeAPIKeyfile . "\n";
}


function DecryptandExtractAPIKey($password)
{
    
    //extract out API Key and salt 
    $encryptedAPIKey = file_get_contents('data.txt');
    $salt = file_get_contents('salt.txt');

    //extract out the iv and tag from txt file
    $lines = file('IVandTag.txt');
    $iv = $lines[0];
    $tag = $lines[1];


    // Using hash_pbkdf2 function to get out key
   // $password = $argv[1];//readline('Enter your password: ');
    $algo = 'sha256';
    $iterations = 100000;
    $len = 50;
    $DataKey = hash_pbkdf2($algo, $password, $salt, $iterations, $len);
    $cipher = "aes-128-gcm";

    //extract out API Key
    
    $API_KEY = openssl_decrypt($encryptedAPIKey, $cipher, $DataKey, $options = 0, $iv, $tag);

    if ($API_KEY != '') {
        //echo "the API key extracted is " . $API_KEY;
        return $API_KEY;
    } else {

        echo "The API Key cannot be extracted";
    }
}

//encryptAPIKey($argv[1]);
//DecryptandExtractAPIKey($argv[1]);

?>