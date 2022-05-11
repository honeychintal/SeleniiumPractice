package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Scrolling {

    @Test(description = "")
    public void scrollTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("scrollBy(0,500)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=200");
        List<WebElement> amount_col = driver.findElements(By.xpath("//table[@id='product']//tbody//tr//td[4]"));
        String[] web_amt_string =driver.findElement(By.cssSelector(".totalAmount")).getText().split(":");
        int web_amt = Integer.parseInt(web_amt_string[1].trim());
        int i=0,count=0;
        System.out.println("amount_col = " + amount_col.size());
        while (i< amount_col.size())
        {
            count =count+Integer.parseInt(amount_col.get(i).getText());
            i++;
        }
        Assert.assertEquals(web_amt,count,"Not matched");
        System.out.println("count = " + count);
    }
}
