/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ict3103busbly;

/**
 *
 * @author pheeb
 */
public class Main {
    public static void main(String[] args) {
        //PasswordRecoveryAuthenticationTest apptest = new PasswordRecoveryAuthenticationTest();
        //BruteForceTest apptest = new BruteForceTest();
        //CreateAccountTest apptest = new CreateAccountTest();
        //LoginTest apptest = new LoginTest();
        //resetPasswordTest apptest = new resetPasswordTest();
    	//BruteForceTest apptest = new BruteForceTest();
    	LoginTest apptest = new LoginTest();
        
        try{
//            apptest.setUp();
//            apptest.test_negative_accountInDatabase();
//            apptest.test_negative_passwordMatchesWithDatabase();
//            apptest.test_negative_verifiedAccount();
//            apptest.test_positive_lockedAccount();
//            apptest.test_positive_login();
//            apptest.test_positive_concurrentLogin();
//            apptest.tearDown();

//            apptest.setUp();
//            apptest.test_positive_resetPassword();
//            apptest.test_negative_resetPassword();
//            apptest.tearDown();

            apptest.setUp();
            apptest.test_negative_passwordMatchesWithDatabase();
            apptest.tearDown();
        }
        catch(InterruptedException ie){
            
        }
        
    }
    
}
