package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest {
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

//        ElementMethods elementMethods = new ElementMethods(driver);
//        FrameMethods frameMethods = new FrameMethods(driver);


        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertsFrameWindowsMenu);

        WebElement frameSubMenu = driver.findElement(By.xpath("//span[text()='Frames']"));
        js.executeScript("arguments[0].click();", frameSubMenu);

        //ne mutam pe un iframe
        driver.switchTo().frame("frame1");

        WebElement sampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleTextElement.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");

        WebElement secondSampleTextElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondSampleTextElement.getText());

    // nested frames - tema
    // sa identificam sa modificam restul testeleor cu JS

    }

}
