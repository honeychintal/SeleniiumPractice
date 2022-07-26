package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyBoardEvents {
    static String url="https://www.iobit.com/en/keyboard-test.php";
    static public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    @Test
    public void keysTest()
    {
        WebDriver driver= setup();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .sendKeys(Keys.ENTER ,Keys.ARROW_DOWN,"a","b","c").perform();
    }
}
