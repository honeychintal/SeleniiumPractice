package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    static String url="https://rahulshettyacademy.com/angularpractice/";
    static public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    @Test
    public void RelativeLocatorstest() {
        WebDriver driver= setup();
        WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));
        System.out.println("Text = " + driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
    }
}
