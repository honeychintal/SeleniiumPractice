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
    static String amazon_url="https://www.amazon.in/";
    static String dragndrop_url="https://jqueryui.com/droppable/";

    static public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    @Test
    public void MouseEventTest() {
        WebDriver driver= setup();
        driver.get(amazon_url);
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
    @Test
    public void dragAndDropTest() {
        WebDriver driver= setup();
        driver.get(dragndrop_url);
        driver.switchTo().frame(0);
        Actions act = new Actions(driver);
        WebElement sourceElement =driver.findElement(By.id("draggable"));
        WebElement destElement =driver.findElement(By.id("droppable"));

//        act
//                .clickAndHold(sourceElement)
//                .moveToElement(destElement)
//                .release()
//                .build()
//                .perform();
        act
                .dragAndDrop(sourceElement,destElement)
                .build()
                .perform();
    }
}
