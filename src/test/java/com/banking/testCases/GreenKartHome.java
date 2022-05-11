package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GreenKartHome {
    static String url="https://rahulshettyacademy.com/seleniumPractise/";
    static WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(groups = "E2E")
    public void AddtoCarttest() {
        String[] items ={"cucumber","beans","mushroom","banana","pomegranate"};
        List<String> itemsList = Arrays.asList(items);
        List<WebElement> webElementList= driver.findElements(By.cssSelector("h4.product-name"));//Titles of all the items
        List<WebElement> button= driver.findElements(By.xpath("//button[text()='ADD TO CART']")); //All the buttons
        for (int i=0;i<webElementList.size();i++)
        {
            String item = webElementList.get(i).getText();
            if(itemsList.contains(item.replace(" - 1 Kg","").toLowerCase(Locale.ROOT)))// removing '- 1 Kg' from all texts
            {
                System.out.println("Text= "+webElementList.get(i).getText());
                button.get(i).click();
            }
        }
    }

    @Test(groups = "E2E")
    public void Checkouttest(){
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        System.out.println("Coupon status= "+driver.findElement(By.cssSelector("span.promoInfo")).getText());

    }
}
