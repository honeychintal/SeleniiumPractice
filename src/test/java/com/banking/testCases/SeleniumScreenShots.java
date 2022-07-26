package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumScreenShots {
//    static String url = "https://www.google.com/";
    static String url = "https://www.javatpoint.com/java-get-current-date";
    @Test(description = "Taking screenshots")
    public void test() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
//        driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys("Screenshots");
//        driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys(Keys.ENTER);
//        driver.findElement(By.cssSelector("a[data-hveid='CAEQBQ']")).click();
        saveScreenshot(driver);
    }
    //Method for screenshot
    public static void saveScreenshot(WebDriver driver) throws IOException {
        //'TakesScreenshot' is an interface and driver is casted as type 'TakesScreenshot'
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destpath= System.getProperty("user.dir")+"\\Screenshots\\SC"+date_time()+".jpg"; 
        FileUtils.copyFile(src,new File(destpath));
    }
    //For unique name for all Screenshot
    public static String date_time() {
        long millis = System.currentTimeMillis();
        // creating a new object of the class Date
        java.util.Date date = new java.util.Date(millis);
        return date.toString().replace(":","_").replace(" ","").trim();
    }
}
