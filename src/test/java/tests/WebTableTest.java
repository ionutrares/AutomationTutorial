package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {
    public WebDriver driver;

    @Test
    public void metodaTest(){
        //deschidem un browser
        driver = new EdgeDriver();
        //accesam un URL
        driver.get("https://demoqa.com/");
        //facem browserul mazimise
        driver.manage().window().maximize();

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click()", elementsMenu);
        //span[text()='Web Tables']

        WebElement webTablesSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        j.executeScript("arguments[0].click()", webTablesSubMenu);
        //span[text()='Web Tables']



        List<WebElement> tableContentList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(), 3, "Default size for table is not 3");



        //definim un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Rareș";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Bucur";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "ionutraresbucur2@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "20";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "1999";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "testing";
        departmentElement.sendKeys(departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();

        List<WebElement> newtableContentList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(newtableContentList.size(), 3, "Default size for table is not 4");

        //validam dimensiunea initiala a tabelului
        String rowContent = newtableContentList.get(3).getText();
//        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(firstNameValue), "The last row doesn't contain first name value");
        Assert.assertTrue(rowContent.contains(firstNameValue), "The last row doesn't contain last name value");
        Assert.assertTrue(rowContent.contains(firstNameValue), "The last row doesn't contain user email value");
        Assert.assertTrue(rowContent.contains(firstNameValue), "The last row doesn't contain age value");
        Assert.assertTrue(rowContent.contains(firstNameValue), "The last row doesn't contain salary value");
        Assert.assertTrue(rowContent.contains(firstNameValue), "The last row doesn't contain department value");

        //edit

        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Catalin";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLastNamelement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Popescu";
        editLastNamelement.clear();
        editLastNamelement.sendKeys(editLastNameValue);

        WebElement editEmailAddress = driver.findElement(By.id("userEmail"));
        String editLastEmailAddress = "ionutrares_bucur@yahoo.com";
        editEmailAddress.clear();
        editEmailAddress.sendKeys(editLastEmailAddress);

        WebElement editAgeValue = driver.findElement(By.id("age"));
        String editLastAgeValue = "34";
        editAgeValue.clear();
        editAgeValue.sendKeys(editLastAgeValue);

        WebElement editSalaryValue = driver.findElement(By.id("salary"));
        String editLastSalaryValue = "600";
        editSalaryValue.clear();
        editSalaryValue.sendKeys(editLastSalaryValue);

        WebElement editDepartmentValue = driver.findElement(By.id("department"));
        String editLastDepartmentValue = "development";
        editDepartmentValue.clear();
        editDepartmentValue.sendKeys(editLastDepartmentValue);

        WebElement editsubmitElement = driver.findElement(By.id("submit"));
        editsubmitElement.click();

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        js.executeScript("arguments[0].click();", editElement);

        newtableContentList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
        Assert.assertEquals(tableContentList.size(), 3, "Default size for table is not 3");



        //validam valorile modificate din tabel
//        rowContent = newtableContentList.get(3).getText();
////        System.out.println(rowContent);
//        Assert.assertTrue(rowContent.contains(editFirstNameValue), "The last row doesn't contain first name value");
//        Assert.assertTrue(rowContent.contains(editLastNameValue), "The last row doesn't contain last name value");
//        Assert.assertTrue(rowContent.contains(editEmailAddress), "The last row doesn't contain user email value");
//        Assert.assertTrue(rowContent.contains(editAgeValue), "The last row doesn't contain age value");
//        Assert.assertTrue(rowContent.contains(editSalaryValue), "The last row doesn't contain salary value");
//        Assert.assertTrue(rowContent.contains(editDepartmentValue), "The last row doesn't contain department value");




        //cum putem sa scriem mai putine linii de cod sa fim mai eficienti? pentru ca sunt submenus pe websit, pana miercuri
        //in weekend sa ne uitam la ambele videouri sa nu lasam programarea
        //aceeasi chestie cu parametrii ca azi, cu 2, 3 masini, punem parametrii respectivi si apelam sus


    }
}
