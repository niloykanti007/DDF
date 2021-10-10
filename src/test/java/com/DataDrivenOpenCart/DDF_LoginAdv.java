package com.DataDrivenOpenCart;

import com.Utils.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DDF_LoginAdv {

    public static WebDriver driver;

    @BeforeClass
    @Parameters("Browser")
    public static void browser_Config(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver1.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/index.php?route=account/login");
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/index.php?route=account/login");
        }
        else {
            System.out.println("Browser not found !!!!");
        }
    }
    @AfterClass
    public static void close_Browser(){
        driver.close();
    }

    @Test(description = "Email and Password Invalid ")
     public static void  TC_Login(){
        //Excel Implement

        Xls_Reader reader = new Xls_Reader("./src/test/TestData/LoginData.xlsx");
        String sheetName = "Sheet1";

        int rowCount = reader.getRowCount(sheetName);

        for(int rowNum = 2; rowNum<=rowCount;rowNum++){
            String email= reader.getCellData(sheetName,"Email", rowNum);
            String password= reader.getCellData(sheetName,"Password", rowNum);



            WebElement Email=driver.findElement(By.id("input-email"));
            Email.clear();
            Email.sendKeys(email);

            WebElement Password=driver.findElement(By.id("input-password"));
            Password.clear();
            Password.sendKeys(password);

            WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
            LoginBtn.click();

            //Verification
            String Expected_Title="Account Login";
            String Actual_title=driver.getTitle();

            if(Expected_Title.equals(Actual_title)){
                //Write on Same Excel
                 reader.setCellData(sheetName,"Result",rowNum,"Test Passed");

            }
            else {
                //Write on Same Excel
                reader.setCellData(sheetName,"Result",rowNum,"Test Failed");
            }


        }

    }


}
