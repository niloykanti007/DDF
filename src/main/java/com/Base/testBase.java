
package com.Base;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;


public class testBase {

    public static WebDriver driver;


    public static void launch_Chrome (){

        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    public static void openURL(String URL){

        if(URL==null){
            return;
        }
        if(URL.isEmpty()){
            return;
        }

        driver.get(URL);

    }

    public static void getPageTitle(){

        String Title=driver.getTitle();
        System.out.println("Title:" +Title);

    }

    public static String getPageURL(){

        return driver.getCurrentUrl();

    }

    public static void close_Chrome (){

        driver.close();

    }


    public static void quit_Chrome (){

        driver.quit();

    }


    //Click Action
    public static void clickOnElementByID(String locator){

        driver.findElement(By.id(locator)).click();

    }


    public static void clickOnElementByNAME(String locator){

        driver.findElement(By.name(locator)).click();

    }


    public static void clickOnElementByCSS(String locator){

        driver.findElement(By.cssSelector(locator)).click();

    }


    public static void clickOnElementByXPATH(String locator){

        driver.findElement(By.xpath(locator)).click();

    }


    public static void clickOnElementByLinkText(String locator){

        driver.findElement(By.linkText(locator)).click();

    }

    //Type(SendKeys)

    public static void typeOnElementByID(String locator, String value){

        driver.findElement(By.id(locator)).sendKeys(value);

    }


    public static void typeOnElementByNAME(String locator, String value ){

        driver.findElement(By.name(locator)).sendKeys(value);

    }


    public static void typeOnElementByCSS(String locator, String value){

        driver.findElement(By.cssSelector(locator)).sendKeys(value);

    }


    public static void typeOnElementByXPATH(String locator, String value){

        driver.findElement(By.xpath(locator)).sendKeys(value);

    }


    //Find WebElement
    public static WebElement getElementByID (String locator){

        return  driver.findElement(By.id(locator));

    }


    //Clear
    public static void clearOnElementByID(String locator){

        driver.findElement(By.id(locator)).clear();

    }


    public static void clearOnElementByNAME(String locator){

        driver.findElement(By.name(locator)).clear();

    }


    public static void clearOnElementByCSS(String locator){

        driver.findElement(By.cssSelector(locator)).clear();
    }


    public static void clearOnElementByXPATH(String locator){

        driver.findElement(By.xpath(locator)).clear();

    }


}