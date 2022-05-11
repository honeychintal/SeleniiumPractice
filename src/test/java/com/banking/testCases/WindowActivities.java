package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class WindowActivities {
    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.get(url);
        driver.navigate().to("https://www.w3schools.in/");
        driver.navigate().to("https://www.tutorialspoint.com/index.htm");
        driver.navigate().to("https://www.w3schools.com/kotlin/kotlin_variables.php");
        driver.navigate().to("https://www.speedtest.net/");
    }

    @Test
    public void windowSwitchTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://rahulshettyacademy.com/loginpagePractise/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> window = windows.iterator();
        String parentid = window.next();
        String childid = window.next();
        driver.switchTo().window(childid);
        driver.findElement(By.xpath("(//a[@href='contact-us'])[3]")).click();
        String email = driver.findElement(By.xpath("(//li)[1]")).getText();
        System.out.println("Text =" + driver.findElement(By.xpath("(//li)[1]")).getText());
        driver.switchTo().window(parentid);
        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.id("signInBtn")).click();
    }
    @Test
    public void iframeTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://jqueryui.com/droppable/";
        driver.manage().window().maximize();
        driver.get(url);
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        driver.findElement(By.id("draggable")).click();
        Actions act = new Actions(driver);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement dest = driver.findElement(By.id("droppable"));
        System.out.println("Before dropping ="+ dest.getText());
        act.dragAndDrop(src,dest).build().perform();
        System.out.println("After dropping = " + dest.getText());
        driver.switchTo().defaultContent();//to switch back to main window
    }

    @Test
    public void switchWindowTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://rahulshettyacademy.com/angularpractice/";
        driver.get(url);
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentW= it.next();
        String childW= it.next();
        driver.switchTo().window(childW);
        driver.get("https://www.rahulshettyacademy.com/");
        String text =driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.switchTo().window(parentW);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(text);
        File file = driver.findElement(By.cssSelector("div.jumbotron")).getScreenshotAs(OutputType.FILE);
        String destpath= System.getProperty("user.dir")+"\\Screenshots\\SC"+SeleniumScreenShots.date_time()+".jpg";
        FileUtils.copyFile(file,new File(destpath));
    }
}
