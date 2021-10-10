package com.BrowserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeConfig {

    public static WebDriver driver;


    public static void main(String[] args) {

        launch_Chrome ();
        //close_Chrome();
        quit_Chrome();

    }
    public static void launch_Chrome (){

        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize(); //maximize window
    }

    public static void close_Chrome (){

        driver.close(); // close only active tab

    }
    public static void quit_Chrome (){

        driver.quit(); //close full browser

    }




}
