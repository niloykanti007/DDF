package browserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromeConfig {

    public static WebDriver driver;


    public static void main(String[] args) {

        launch_Chrome ();
        close_Chrome();


    }
    public static void launch_Chrome (){

        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void close_Chrome (){

        driver.close();
    }



}