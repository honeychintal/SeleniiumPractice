package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksHandel {
    @Test
    public void test() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        URL url;
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        WebElement footer_div = driver.findElement(By.xpath("(//div[@id='gf-BIG']//ul)[2]"));
        List<WebElement> links = footer_div.findElements(By.tagName("a"));

        for (WebElement e:links)
        {
            String s=e.getAttribute("href");
            url=new URL(s);
            HttpURLConnection huc=(HttpURLConnection)url.openConnection();
           int resp= huc.getResponseCode();
           if(resp>200)
           {
               System.out.println(s+" Link is broken :(");
           }
           else {
               System.out.println(s+" Link works fine :)");
           }
        }
    }
}
