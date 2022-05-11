package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class CalenederTest {
    @Test(description = "count all the links present in the web page and display the links")
    public void selectDateTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://www.path2usa.com/travel-companions";
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String dayToSelect ="18";
        String monthToSelect ="october";
        driver.findElement(By.id("travel_date")).click();


        while (!driver.findElement(By.cssSelector(".datepicker-switch")).getText().toLowerCase(Locale.ROOT).contains(monthToSelect)){
            driver.findElement(By.cssSelector("th.next")).click();
        }
        List<WebElement> days = driver.findElements(By.cssSelector(".day"));
        for(WebElement we: days)
        {
            String itr_day =we.getText();
            System.out.println("itr_day = " + itr_day);
            if (itr_day.equals(dayToSelect))
            {
                we.click();
                System.out.println("Clicked on "+itr_day);
                break;
            }
        }
    }
}
