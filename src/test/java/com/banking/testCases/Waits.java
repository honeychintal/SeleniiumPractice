package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Waits {
    static String url="https://rahulshettyacademy.com/dropdownsPractise/";
    static public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    @Test
    public void implicitWaitTest() {
        WebDriver driver= setup();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://artoftesting.com/waits-in-selenium-webdriver");
        driver.quit();
    }
    @Test
    public void explicitWaitTest() {
        WebDriver driver= setup();
        WebElement searchBtn= driver.findElement(By.xpath("//input[@value='Search']"));
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
        driver.quit();
    }
    @Test
    public void fluentWaitTest() {
        WebDriver driver= setup();
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement element= (WebElement) wait.until(new Function<WebDriver,WebElement>() {
                public WebElement apply(WebDriver driver1) {
                return driver1.findElement(By.xpath("//input[@value='Search']"));
            }
        });
        element.click();
        driver.close();
        }
    }
