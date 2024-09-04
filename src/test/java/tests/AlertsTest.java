package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {

    public WebDriver driver;

    @Test

    public void metodaTest() {
        // deschidem un browser
        driver = new EdgeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browser-ul maximize
        driver.manage().window().maximize();
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ElementMethods elementMethods = new ElementMethods(driver);
        AlertMethods alertMethods = new AlertMethods(driver);

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickJSElement(alertsFrameWindowsMenu);

        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementMethods.clickJSElement(alertsSubMenu);

        WebElement okAlertElement = driver.findElement(By.id("alertButton"));
        elementMethods.clickElement(okAlertElement);


        alertMethods.acceptAlert();


        WebElement timerAlertButtonElement = driver.findElement(By.id("timerAlertButton"));
        elementMethods.clickElement(timerAlertButtonElement);

        //wait explicit

        alertMethods.acceptAlert();

        WebElement confirmAlertElement = driver.findElement(By.id("confirmButton"));
        elementMethods.clickElement(confirmAlertElement);


        alertMethods.dismissAlert();


        WebElement promtAlertElement = driver.findElement(By.id("promtButton"));
        elementMethods.clickElement(promtAlertElement);


        alertMethods.fillAlert("this is a test");



    }

}
