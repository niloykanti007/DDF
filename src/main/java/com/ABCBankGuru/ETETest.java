package com.ABCBankGuru;

import com.Base.testBase;


public class ETETest extends testBase {

    public static void main(String[] args) throws InterruptedException {

        launch_Chrome();

        openURL("http://demo.guru99.com/V4/index.php");
        loginETE.TC_Login_ETN_001();

        AddCustomerETE.openURL("http://demo.guru99.com/V4/manager/addcustomerpage.php");
        AddCustomerETE.TC_NewCustomer_ETE_01();
        Thread.sleep(5000);
        logOut.TC_logout();

        close_Chrome();

    }


}
