package tests;

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

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertsFrameWindowsMenu);

        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        js.executeScript("arguments[0].click();", alertsSubMenu);

        WebElement okAlertElement = driver.findElement(By.id("alertButton"));
        js.executeScript("arguments[0].click();", okAlertElement);


        Alert firstAlert=driver.switchTo().alert();
        System.out.println(firstAlert.getText());
        firstAlert.accept();


        WebElement timerAlertButtonElement = driver.findElement(By.id("timerAlertButton"));
        js.executeScript("arguments[0].click();", timerAlertButtonElement);

        //wait explicit
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.alertIsPresent());

        Alert secondAlert=driver.switchTo().alert();
        System.out.println(secondAlert.getText());
        secondAlert.accept();

        WebElement confirmAlertElement = driver.findElement(By.id("confirmButton"));
        js.executeScript("arguments[0].click();", confirmAlertElement);

        Alert thirdAlert=driver.switchTo().alert();
        System.out.println(thirdAlert.getText());
        //thirdAlert.accept();
        thirdAlert.dismiss();


        WebElement promtAlertElement = driver.findElement(By.id("promtButton"));
        js.executeScript("arguments[0].click();", promtAlertElement);

        Alert fourthAlert=driver.switchTo().alert();
        System.out.println(fourthAlert.getText());
        fourthAlert.sendKeys("this is a test");
        fourthAlert.accept();


    }

}
