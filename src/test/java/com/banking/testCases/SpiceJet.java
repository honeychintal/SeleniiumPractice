package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpiceJet {
    static String url="https://rahulshettyacademy.com/dropdownsPractise/";
    @Test
    public void endTOendTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        driver.findElement(By.xpath("//a[@text='Coimbatore (CJB)']")).click();
        Thread.sleep(2000);
        System.out.println("value = " + driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        driver.findElement(By.id("divpaxinfo")).click();
        int i=0;
        Thread.sleep(2000);
        while (i<4){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        WebElement dropDwnelement = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
        Select dropDown = new Select(dropDwnelement);
        dropDown.selectByValue("USD");
        driver.findElement(By.cssSelector("input#ctl00_mainContent_btn_FindFlights")).click();
    }
}
