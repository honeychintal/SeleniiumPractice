package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrowserOptionsMethods {
    @Test(description = "Bypass the expired SSL securities page")
    public void test() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true); //Accept expired ssl certificate webpage
        WebDriver driver = new ChromeDriver(options);
        String url = "https://expired.badssl.com/";
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("Text on page: "+driver.findElement(By.xpath("//h1")).getText());
    }
}
