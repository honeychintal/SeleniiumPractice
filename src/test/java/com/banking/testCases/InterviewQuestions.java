package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class InterviewQuestions {

    @Test(description = "count all the links present in the web page and display the links")
    public void countAllLinks() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://www.amazon.in/";
        driver.manage().window().maximize();
        driver.get(url);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of Links in page= "+links.size());
        for(WebElement we: links)
        {
            System.out.println(">> "+we.getAttribute("href"));
        }
    }
    @Test(description = "count the links present in the specific area,(navBar only)")
    public void countSpecificAreaLinks() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://www.amazon.in/";
        driver.manage().window().maximize();
        driver.get(url);
        WebElement nav_area =driver.findElement(By.id("nav-xshop")); //area of navigation bar
        List<WebElement> links = nav_area.findElements(By.tagName("a"));
        System.out.println("Number of Links in page= "+links.size());
        for(WebElement we: links)
        {
            if (we.getText().isEmpty()||we.getText().equals(null)||we.getText().equals(""))
                continue;
            System.out.println("Visible link:>> {"+we.getAttribute("href")+"},{"+we.getText()+"}");
        }
    }
}
