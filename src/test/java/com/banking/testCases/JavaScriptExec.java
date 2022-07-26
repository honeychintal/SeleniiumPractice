package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptExec {
    static String url="https://demo.guru99.com/V4/";
    static public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    @Test
    public void sleepAsyncScript(){
        WebDriver driver = setup();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        long start_time = System.currentTimeMillis();
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
        //Get the difference (currentTime - startTime)  of times.
        System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));
    }

    @Test(description = "scroll until web element is not found")
    public void Script(){
        WebDriver driver = setup();
        driver.get("https://www.guru99.com/execute-javascript-selenium-webdriver.html");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement find_elm = driver.findElement(By.xpath("//div[contains(@id,'kt-info-box_c022d7-f5')]"));
        js.executeScript("arguments[0].scrollIntoView();",find_elm);
    }
}
