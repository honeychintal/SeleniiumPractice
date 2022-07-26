package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class E2EAssignment1 {
    static String url="https://rahulshettyacademy.com/loginpagePractise/";
    static WebDriver driver;
    static WebDriverWait wait;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver,15);
    }
    @Test
    public void login() {
        List<WebElement> elements = driver.findElements(By.xpath("//p[@class='text-center text-white']//b"));
        String user = elements.get(0).getText();
        String pass = elements.get(1).getText();
        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@value='user']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));
        WebElement modal = driver.findElement(By.cssSelector(".modal-content"));
        modal.findElement(By.xpath("//div[@class='modal-content']//button[@id='okayBtn']")).click();//wiat for alert
        WebElement drdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropDown = new Select(drdown);
        dropDown.selectByValue("teach");
        driver.findElement(By.id("signInBtn")).click();
    }
    @Test(dependsOnMethods = "login")
    public void addtocart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='ProtoCommerce']")));
        List<WebElement> buttons= driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        buttons.stream().forEach(s->s.click());
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
    }
}
