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

public class DDF_Registration {

    public static WebDriver driver;

    @BeforeClass
    @Parameters("Browser")
    public static void browser_Config(String browserName){

        if(browserName.equalsIgnoreCase("Chrome")){

            System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/index.php?route=account/register");
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/index.php?route=account/register");
        }
        else {
            System.out.println("Browser not found !!!!");
        }
    }
    @AfterClass
    public static void close_Browser(){

        driver.close();
    }

    @Test(description = "Invalid Registration ")
     public static void  TC_Registration(){
        //Excel Implement

        Xls_Reader reader = new Xls_Reader("./src/test/TestData/RegistrationData.xlsx");
        String sheetName = "Sheet1";

        int rowCount = reader.getRowCount(sheetName);

        for(int rowNum = 2; rowNum<=rowCount;rowNum++){
            String firstname= reader.getCellData(sheetName,"FirstName", rowNum);
            String lastname= reader.getCellData(sheetName,"LastName", rowNum);
            String email= reader.getCellData(sheetName,"Email", rowNum);
            String telephone= reader.getCellData(sheetName,"Telephone", rowNum);
            String password= reader.getCellData(sheetName,"Password", rowNum);
            String passconfirm= reader.getCellData(sheetName,"PasswordConfirm", rowNum);



            //First_Name
            WebElement First_Name = driver.findElement(By.id("input-firstname"));
            First_Name.clear();
            First_Name.sendKeys(firstname);

            //Last_Name
            WebElement Last_Name = driver.findElement(By.id("input-lastname"));
            Last_Name.clear();
            Last_Name.sendKeys(lastname);

            //Email
            WebElement Email = driver.findElement(By.id("input-email"));
            Email.clear();
            Email.sendKeys(email);

            //Telephone
            WebElement Telephone = driver.findElement(By.id("input-telephone"));
            Telephone.clear();
            Telephone.sendKeys(telephone);

            //Password
            WebElement Password = driver.findElement(By.id("input-password"));
            Password.clear();
            Password.sendKeys(password);

            //Confirm_Password
            WebElement Confirm_Password = driver.findElement(By.id("input-confirm"));
            Confirm_Password.clear();
            Confirm_Password.sendKeys(passconfirm);

            //Newsletter
            WebElement Newsletter = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input"));
            Newsletter.click();

            //Privacy_Policy
            WebElement Privacy_Policy = driver.findElement(By.name("agree"));

            if(Privacy_Policy.isSelected()){

            }
            else {

                Privacy_Policy.click();
            }

            //ContinueBtn
            WebElement ContinueBtn = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
            ContinueBtn.click();

            //Verification By Title
            String Expected_Title = "Register Account";
            String Actual_Title = driver.getTitle();

            if(Expected_Title.equals(Actual_Title)){

                //Write on Same Excel
                reader.setCellData(sheetName,"Result",rowNum,"Test Passed");

                System.out.println("Test Case Passed");
            }
            else{

                //Write on Same Excel
                reader.setCellData(sheetName,"Result",rowNum,"Test Failed");
                System.out.println("Test Case failed");
            }


        }


        }

    }



