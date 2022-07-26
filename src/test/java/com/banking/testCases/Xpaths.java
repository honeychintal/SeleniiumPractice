package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Xpaths {
    static String url="https://www.w3schools.in/";
    static public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    @Test
    public void xpathTest()
    {
        WebDriver driver= setup();
        System.out.println(driver.findElement(By.xpath("//input[@id='SearchTerm']")).getText());
        System.out.println(driver.findElement(By.xpath("//button[text()='Search']")).getText()); //text()
        System.out.println(driver.findElement(By.xpath("//button[contains(text(),'Search')]")).getText()); //contains
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'C++')]//parent::div[contains(@class,'rounded-1')]")).toString()); //parent
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'C++ 11')]//preceding-sibling::a[contains(text(),'C++')]")).toString()); //preceding-sibling
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'C++ 11')]//following-sibling::a[contains(text(),'JSP')]")).getText()); //following-sibling
    }
}
