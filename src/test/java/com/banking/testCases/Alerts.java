package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts
{
    static public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        return driver;
    }
    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys("Prajjaval");
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        System.out.println("text= "+driver.switchTo().alert().getText());
        Thread.sleep(4000);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();
    }
    @Test
    public void testCookie() throws InterruptedException {
        WebDriver driver= setup();
        driver.get("https://www.browserstack.com/users/sign_up");
        driver.findElement(By.id("user_full_name")).sendKeys("Kantharaj kundra");
        driver.findElement(By.id("user_email_login")).sendKeys("Kantharaju@newMail.com");
        driver.findElement(By.id("user_password")).sendKeys("Kanthu@4321");
        WebElement element= driver.findElement(By.cssSelector(".cookie-notification"));
        if (element.isDisplayed())
        {
            element.findElement(By.cssSelector(".cookie-notification__close")).click();
        }
        driver.findElement(By.id("user_submit")).click();
    }

    @Test
    public void testWithAlertClass() throws InterruptedException {
        WebDriver driver= setup();
        driver.get("https://demoqa.com/alerts");
        //Alert ---- 1
        driver.findElement(By.id("alertButton")).click();
        Alert immidiateAlert= driver.switchTo().alert();
        System.out.println("1st Alert text: "+immidiateAlert.getText());
        immidiateAlert.accept();

        //Alert ---- 2
        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(6000);
        Alert delay5sAlert= driver.switchTo().alert();
        System.out.println("2nd Alert text: "+delay5sAlert.getText());
        delay5sAlert.accept();

        Thread.sleep(6000);
        //Alert ---- 3
        driver.findElement(By.id("promtButton")).click();
        Alert inputAlert= driver.switchTo().alert();
        System.out.println("2nd Alert text: "+inputAlert.getText());
        inputAlert.sendKeys("Hellooooooo There");
        inputAlert.accept();
    }
}
