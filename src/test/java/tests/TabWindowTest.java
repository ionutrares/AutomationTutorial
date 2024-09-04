package tests;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TabWindowTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        //Deschidem un browser
        driver = new EdgeDriver();
        //Accesam un URL
        driver.get("https://demoqa.com/");
        //Maximizam browserul folosit, sa fie full screen
        driver.manage().window().maximize();

        ElementMethods elementMethods = new ElementMethods(driver);
        TabMethods tabMethods = new TabMethods(driver);

        WebElement alertFrameWindowMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", alertFrameWindowMenu);
        elementMethods.clickJSElement(alertFrameWindowMenu);

        WebElement browserWindowElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        //js.executeScript("arguments[0].click();", browserWindowElement);
        elementMethods.clickJSElement(browserWindowElement);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
      //  js.executeScript("arguments[0].click();", newTabElement);
        elementMethods.clickJSElement(newTabElement);

//        System.out.println("URL-ul paginii curente este " + driver.getCurrentUrl());
//
//        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabsList.get(1));
//
//        System.out.println("URL-ul paginii curente este " + driver.getCurrentUrl());
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);

        //driver.close();

       // driver.switchTo().window(tabsList.get(0));

       // System.out.println("URL-ul paginii curente este " + driver.getCurrentUrl());

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        //js.executeScript("arguments[0].click();", newWindowElement);
        elementMethods.clickJSElement(newWindowElement);

//        System.out.println("URL-ul paginii curente este " + driver.getCurrentUrl());
//
//        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windowsList.get(1));
//
//        System.out.println("URL-ul paginii curente este " + driver.getCurrentUrl());
//
//        driver.close();
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();


        driver.quit();

    }
}
