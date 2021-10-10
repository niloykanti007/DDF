package com.ABCBankGuru;

import com.Base.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class loginETE extends testBase {

    public static void main(String[] args) {

        launch_Chrome();

        openURL("http://demo.guru99.com/V4/index.php");

        TC_Login_ETN_001();

        close_Chrome();
    }


    public static void TC_Login_ETN_001(){

        //step 1
        WebElement UserId = driver.findElement(By.name("uid"));
        UserId.clear();
        UserId.sendKeys("mngr357095");

        //step 2
        WebElement Password = driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("pezaqUn");

        //Step 3
        WebElement LoginBtn = driver.findElement(By.name("btnLogin"));
        LoginBtn.click();

        //Verify by Title
        String Expected_Title = "Guru99 Bank Manager HomePage";
        String Actual_title = driver.getTitle();


        if (Expected_Title.equals(Actual_title)) {

            System.out.println("Test Case Passed.");

        } else {
            System.out.println("Test Case failed.");
        }


    }
}
