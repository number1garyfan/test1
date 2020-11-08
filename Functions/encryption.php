
<?php


function pushDataToFile($data, $file)
{


    $fp = fopen($file, 'w') or die("Unable to open file!");
    fwrite($fp, $data);
    fclose($fp);
}

function encryptAPIKey()
{
    $apiKey = 'Youhavefoundtheflagmadness123456789';
    $password = readline('Enter your password: ');
    $algo = 'sha256';
    $salt = openssl_random_pseudo_bytes(16);
    $iterations = 1000;
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
    echo "Salt value has been pushed into " . $saltFile ."\n";

    pushDataToFile($iv, $IVandTag);
    echo "IV value has been pushed into " . $IVandTag ."\n";

    file_put_contents($IVandTag, $tag, FILE_APPEND);
    echo "Tag value has been pushed into " . $IVandTag ."\n";


    //store encrypted API key in file 
    pushDataToFile($ciphertext, $storeAPIKeyfile);
    echo "Encrypted API Key value has been pushed into " . $storeAPIKeyfile ."\n";

    
}


function DecryptandExtractAPIKey()
{

    //extract out API Key and salt 
    $encryptedAPIKey = file_get_contents('data.txt');
    $salt = file_get_contents('salt.txt');

    //extract out the iv and tag from txt file
    $lines = file('IVandTag.txt');
    $iv = $lines[0];
    $tag = $lines[1];


    // Using hash_pbkdf2 function to get out key
    $password = readline('Enter your password: ');
    $algo = 'sha256';
    $iterations = 1000;
    $len = 50;
    $DataKey = hash_pbkdf2($algo, $password, $salt, $iterations, $len);
    

    $cipher = "aes-128-gcm";

    //extract out API Key
    
    $API_Key = openssl_decrypt($encryptedAPIKey, $cipher, $DataKey, $options = 0, $iv, $tag);

    if($API_Key != ''){
        echo "the API key extracted is " . $API_Key;
        //return $API_Key;
    }
    else{

        echo "The API Key cannot be extracted";
    }
     
}

encryptAPIKey();
DecryptandExtractAPIKey();



?>