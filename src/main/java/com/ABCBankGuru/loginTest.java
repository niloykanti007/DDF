package com.ABCBankGuru;


import com.Base.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginTest extends testBase {

    public static WebDriver driver;

    public static void main(String[] args){

        launch_Chrome();
        openURL("http://demo.guru99.com/V4/index.php");

        TC_Login_001();
        TC_Login_002();
        TC_Login_003();
        TC_Login_004();

        close_Chrome();

    }


     /*
        uid: mngr357095
        pass : pezaqUn

     */


    //valid user_id and password
    public static void TC_Login_001(){

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


    //invalid user_id and password
    public static void TC_Login_002() {

        //Step 3
        WebElement UserId =driver.findElement(By.name("uid"));
        UserId.clear();
        UserId.sendKeys("habijabi");

        //Step 4
        WebElement Password = driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("0000000");

        //Step 5
        WebElement LoginBtn = driver.findElement(By.name("btnLogin"));
        LoginBtn.click();

        driver.switchTo().alert().accept(); //ok button

        //Verify by Title
        String Expected_Title = "Guru99 Bank Home Page";
        String Actual_title = driver.getTitle();


        if (Expected_Title.equals(Actual_title)) {
            System.out.println("Account Successfully Login.Test Case Passed.");
        } else {
            System.out.println("Test Case failed.");
        }

        System.out.println("TC_Login_002 Executed");
    }

    //valid user_id and invalid password
    public static void TC_Login_003() {

        //Step 3
        WebElement UserId = driver.findElement(By.name("uid"));
        UserId.clear();
        UserId.sendKeys("mngr357095");

        //Step 4
        WebElement Password = driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("ksjdfh55");

        //Step 5
        WebElement LoginBtn = driver.findElement(By.name("btnLogin"));
        LoginBtn.click();

        driver.switchTo().alert().accept(); //ok button

        //Verify by Title
        String Expected_Title = "Guru99 Bank Home Page";
        String Actual_title = driver.getTitle();


        if (Expected_Title.equals(Actual_title)) {

            System.out.println("Test Case Passed.");

        } else {
            System.out.println("Test Case failed.");
        }

        System.out.println("TC_Login_003 Executed");

    }


    //invalid user_id and valid password
    public static void TC_Login_004() {

        //Step 3
        WebElement UserId = driver.findElement(By.name("uid"));
        UserId.clear();
        UserId.sendKeys("m");

        //Step 4
        WebElement Password = driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("pezaqUn");

        //Step 5
        WebElement LoginBtn = driver.findElement(By.name("btnLogin"));
        LoginBtn.click();

        driver.switchTo().alert().accept(); //ok button

        //Verify by Title
        String Expected_Title = "Guru99 Bank Home Page";
        String Actual_title = driver.getTitle();


        if (Expected_Title.equals(Actual_title)) {

            System.out.println("Test Case Passed.");

        } else {
            System.out.println("Test Case failed.");
        }

        System.out.println("TC_Login_004 Executed");

    }

}