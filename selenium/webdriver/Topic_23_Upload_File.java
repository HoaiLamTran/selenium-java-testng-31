package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import javax.print.DocFlavor;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Topic_23_Upload_File {
    WebDriver driver;

    String projectPath = System.getProperty("user.dir");
    String uploadFilePath = projectPath + "\\uploadFile\\";

    String dannyName = "danny.jpg";
    String karlName ="karl.jpg";
    String luiseName = "luise.jpg";
    String mosName = "mos.jpg";

    String dannyPath = uploadFilePath + dannyName;
    String karlPath = uploadFilePath + karlName;
    String luisePath = uploadFilePath + luiseName;
    String mosPath = uploadFilePath + mosName;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Single(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
    By uploadFile = By.xpath("//input[@type=\"file\"]");

        // Load File
        driver.findElement(uploadFile).sendKeys(dannyPath);
        driver.findElement(uploadFile).sendKeys(karlPath);
        driver.findElement(uploadFile).sendKeys(luisePath);
        driver.findElement(uploadFile).sendKeys(mosPath);

        //Verify load file success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+dannyName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ karlName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ luiseName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ mosName+"']")).isDisplayed());

        //Upload từng File
        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement start: startButtons) {
            start.click();
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException e)
            {
                // this part is executed when an exception (in this example InterruptedException) occurs
            }
        }

        //Verify upload file success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ dannyName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ karlName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ luiseName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ mosName +"']")).isDisplayed());

    }
    @Test
    public void TC_02_Multiple(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By uploadFile = By.xpath("//input[@type=\"file\"]");

        // Load File
        driver.findElement(uploadFile).sendKeys(dannyPath + "\n" + karlPath + "\n" + luisePath + "\n" + mosPath);

        //Verify load file success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+dannyName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ karlName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ luiseName+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ mosName+"']")).isDisplayed());

        //Upload từng File
        List<WebElement> startButtons = driver.findElements(By.cssSelector("table button.start"));

        for (WebElement start: startButtons) {
            start.click();
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException e)
            {
                // this part is executed when an exception (in this example InterruptedException) occurs
            }
        }

        //Verify upload file success
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ dannyName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ karlName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ luiseName +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[text()='"+ mosName +"']")).isDisplayed());

    }
    @AfterClass
    public void cleanbrowser(){
//        driver.quit();
    }
}
