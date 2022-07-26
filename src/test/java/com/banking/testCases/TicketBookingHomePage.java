package com.banking.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class TicketBookingHomePage {
    static String url="https://rahulshettyacademy.com/dropdownsPractise/";
   static public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
       driver.manage().window().maximize();
       driver.get(url);
        return driver;
    }

    @Test
    public void test() throws InterruptedException {
        WebDriver driver= setup();
        String[] dropValues ={"USD","INR","AED"};
        WebElement dropDwnelement = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
        Select dropDown = new Select(dropDwnelement);
        for(String val:dropValues)
        {
            dropDown.selectByValue(val);
            System.out.println("dropdown value = "+dropDown.getFirstSelectedOption().getText());
            Thread.sleep(2000);
        }
    }
    @Test
    public void staticDropdown() throws InterruptedException {
        WebDriver driver= setup();
        driver.findElement(By.id("divpaxinfo")).click();
        int i=0;
        Thread.sleep(2000);
        while (i<4){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println("dropdown value = "+driver.findElement(By.cssSelector(".paxinfo")).getText());
    }
    @Test
    public void dynamicDropdown() throws InterruptedException {
        WebDriver driver= setup();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        driver.findElement(By.xpath("//a[@text='Coimbatore (CJB)']")).click();
        Thread.sleep(2000);
        System.out.println("value = " + driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
        //indexed Xpath
//        driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();
        //Parent child Xpath
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BLR']")).click();
    }

    @Test
    public void autoSuggestDropdown() throws InterruptedException {
        WebDriver driver= setup();
        driver.findElement(By.cssSelector("#autosuggest")).sendKeys("ko");
        Thread.sleep(2000);

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option:options)
        {
            if (option.getText().equalsIgnoreCase("Korea, Republic of"))
            {
                option.click();
            }
        }
    }
    @Test
    public void checkBox(){
        WebDriver driver= setup();
        System.out.println(driver.findElement(By.cssSelector("input[id*='CitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='CitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='CitizenDiscount']")).isSelected());

        //
    }    
    @Test
    public void checkBox_assignment(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.cssSelector("#checkBoxOption1")).click();
        System.out.println(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
        driver.findElement(By.cssSelector("#checkBoxOption1")).click();
        System.out.println(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
    }
    @Test
    public void calanderTest() throws InterruptedException {
        WebDriver driver= setup();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        driver.findElement(By.xpath("//a[@text='Coimbatore (CJB)']")).click();
        Thread.sleep(2000);
        System.out.println("value = " + driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
        driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
    }

    @Test
    public void disabledElementTest()  {
        WebDriver driver= setup();
//        driver.findElement(By.cssSelector("input#ctl00_mainContent_view_date2")).isEnabled();
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
        {
            System.out.println("Webelement Disabled");
        }
        driver.findElement(By.cssSelector("input#ctl00_mainContent_view_date2")).click();
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
        {
            System.out.println("Webelement Disabled");
        }
        else {System.out.println("Webelement Enabled");}
   }
    
}
