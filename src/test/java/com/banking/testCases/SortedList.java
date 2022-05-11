package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SortedList {
    static String url="https://rahulshettyacademy.com/seleniumPractise/#/offers";
    static public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    @Test
    public void sortedListTest(){
        WebDriver driver= setup();
        driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
        List<WebElement> items = driver.findElements(By.xpath("//td[1]"));
        List<String> actualItemslist =items.stream().map(s-> s.getText()).collect(Collectors.toList());
        List<String> expItemslist =actualItemslist.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(actualItemslist.equals(expItemslist));
    }
    @Test
    public void getPriceTest(){
        WebDriver driver= setup();
        List<WebElement> items = driver.findElements(By.xpath("//td[1]"));
        List<String> price = items.stream().filter(s-> s.getText().equalsIgnoreCase("wheat")).map(s-> getprice(s)).collect(Collectors.toList());
        price.forEach(s -> System.out.println("price: "+s));
    }
    private String getprice(WebElement we) {
     return we.findElement(By.xpath("//td[1]/following-sibling::td[1]")).getText();
    }
    @Test
    public void getPriceWithPaginationTest(){
        WebDriver driver= setup();
        String itemName="almond";
        List<String> price;
        do {
            List<WebElement> items = driver.findElements(By.xpath("//td[1]"));
            price = items
                    .stream()
                    .filter(s-> s.getText().equalsIgnoreCase(itemName))
                    .map(s-> getprice(s))
                    .collect(Collectors.toList());
            try {
                if(price.size()<1)
                {
                    driver.findElement(By.cssSelector("[aria-label='Next']")).click();
                }
            }
            catch (Exception e)
            {
                System.out.println(" your item not found !! "+e);
                break;
            }
        }while(price.size()<1);
        System.out.println("price of "+itemName+"= " + price);
    }

    @Test
    public void filterTest(){
        WebDriver driver= setup();
        String itemName ="al";
        driver.findElement(By.id("search-field")).sendKeys(itemName);
        List<WebElement> items = driver.findElements(By.xpath("//td[1]"));
        List<String> price = items.stream().filter(s-> s.getText().contains(itemName)).map(s-> s.getText()).collect(Collectors.toList());
        price.forEach(s -> System.out.println("price: "+s));
    }
}
