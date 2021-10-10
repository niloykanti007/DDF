package com.ABCBankGuru;


import com.Base.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddCustomer extends testBase {

    public static WebDriver driver;

    public static void main(String[] args){
        launch_Chrome();
        openURL("http://demo.guru99.com/V4/manager/addcustomerpage.php");
        TC_NewCustomer_001();

    }


    public static void TC_NewCustomer_001() {

        WebElement Addcustomer = driver.findElement(By.cssSelector("body > div:nth-child(7) > div > ul > li:nth-child(2)"));
        Addcustomer.click();

        WebElement Customer_name = driver.findElement(By.name("name"));
        Customer_name.clear();
        Customer_name.sendKeys("don");

        WebElement Gender = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=radio]:nth-child(2)"));
        Gender.click();


        //Find the date time picker control

        WebElement dateBox = driver.findElement(By.cssSelector("#dob"));

        //Fill date as dd/mm/yyyy as 22/03/1992

        dateBox.sendKeys("2203");
        dateBox.sendKeys(Keys.TAB);
        //Press tab to shift focus to time field
        dateBox.sendKeys("1992");

        WebElement Address = driver.findElement(By.name("addr"));
        Address.clear();
        Address.sendKeys("Bangladesh");

        WebElement City = driver.findElement(By.name("city"));
        City.clear();
        City.sendKeys("Dhaka");

        WebElement State = driver.findElement(By.name("state"));
        State.clear();
        State.sendKeys("Dhanmondi");

        WebElement Pin = driver.findElement(By.name("pinno"));
        Pin.clear();
        Pin.sendKeys("1205");

        WebElement Telephone = driver.findElement(By.name("telephoneno"));
        Telephone.clear();
        Telephone.sendKeys("0000000000");


        WebElement Email = driver.findElement(By.name("emailid"));
        Email.clear();
        Email.sendKeys("habijabi@gmail.com");

        WebElement Password = driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("01230123");

        WebElement Submit = driver.findElement(By.name("sub"));
        Submit.click();

        WebElement Reset = driver.findElement(By.name("res"));
        Reset.click();
    }
}