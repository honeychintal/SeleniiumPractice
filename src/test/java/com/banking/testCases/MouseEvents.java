package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseEvents {
    static String url="https://www.amazon.in/";
    static public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    @Test
    public void MouseEventTest() {
        WebDriver driver= setup();
        Actions act = new Actions(driver);
        WebElement searchInput =driver.findElement(By.id("twotabsearchtextbox"));
        //Send keys and Search the text
//        act.moveToElement(searchInput)
//                .click()
//                .keyDown(Keys.SHIFT)
//                .sendKeys("suede shoes")
//                .sendKeys(Keys.ENTER)
//                .build()
//                .perform();

        //Send keys and double click the text
        act.moveToElement(searchInput)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("suede shoes")
                .doubleClick()
                .build()
                .perform();
    }
}
