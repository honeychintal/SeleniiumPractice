package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    @Test
    public void wrongPasswordLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String url="https://rahulshettyacademy.com/locatorspractice/";
        driver.get(url);
        driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Bachann");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("pandey");
        driver.findElement(By.className("signInBtn")).click();
        String errmsg=driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println("errmsg = " + errmsg);
        driver.close();
    }

    @Test
    public void forgetPassword() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String strArr[];
        String passwdString, passwordfound;
        String url="https://rahulshettyacademy.com/locatorspractice/";
        driver.get(url);
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("john Cena");
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("123abc");
        driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("9087654321");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        passwdString = driver.findElement(By.cssSelector("form p")).getText();
        System.out.println("passwdString = " + passwdString);
        strArr = passwdString.split("'");
        for(String x: strArr)
        {
            System.out.println(x);
        }
        passwordfound=strArr[1];
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Bachann");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(passwordfound);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
//        driver.close();
    }
    @Test
    public void loginHappyPath() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String url="https://rahulshettyacademy.com/locatorspractice/";
        driver.get(url);
        driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Bachann");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        String str =driver.findElement(By.cssSelector("div p")).getText();
        Assert.assertEquals(str,"You are successfully logged in.");
    }
}
