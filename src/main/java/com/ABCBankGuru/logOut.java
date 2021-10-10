package com.ABCBankGuru;

import com.Base.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class logOut extends testBase {

    public static void main(String[] args) {

        TC_logout();
    }
    public static void TC_logout(){


        //home button press
        WebElement Home=driver.findElement(By.linkText("Home"));
        Home.click();

        //Logout
        WebElement Logout=driver.findElement(By.linkText("Log out"));
        Logout.click();
        driver.switchTo().alert().accept(); //ok button

    }


}

