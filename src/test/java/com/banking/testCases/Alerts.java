package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alerts
{
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
}
