package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.SessionNotCreatedException;


import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_11_Default_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
//        driver = new ChromeDriver();
//        driver = new FirefoxDriver();

        // Tắt capcha
//        EdgeOptions edgeOptions = new ChromeOptions();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--user-data-dir=C:\\Users\\h.lam_\\AppData\\Local\\Google\\Chrome\\User Data\\");
//        chromeOptions.addArguments("--profile-directory=Profile 9");
//        driver = new ChromeDriver(chromeOptions) ;

        // Tắt location
//        ChromeOptions option = new ChromeOptions();
//        options.addArguments("--disable-geolocation");
//        driver = new ChromeDriver(options);

        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("geo.enabled", false);
        option.addPreference("geo.provider.use_corelocation", false);
        driver = new FirefoxDriver(option);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void Topic_01_nopCommerce(){
        driver.get("https://demo.nopcommerce.com/register");

        String firstName = "Lam";
        String lastName = "Tran";
        String date = "1";
        String month = "May";
        String year = "1997";
        String email = "lamth" + new Random().nextInt(9999) +"@yopmail.com";
        String company = "AutomationFC";
        String password = "lamth123456@";

        driver.findElement(By.cssSelector("input#gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText(date);
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText(month);
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText(year);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys(company);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

        driver.findElement(By.cssSelector("a.ico-account")).click();
        Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"),lastName);

        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).getFirstSelectedOption().getText(),date);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).getFirstSelectedOption().getText(),year);

        Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"),email);
        Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"),company);
    }
    @Test
    public void Topic_02_Rode(){
        driver.get("https://rode.com/en/support/where-to-buy");


        new Select(driver.findElement(By.cssSelector("select[id='country']"))).selectByVisibleText("Vietnam");
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("Ho Chi Minh");
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        driver.findElement(By.xpath("//button[text()='Search']")).click();

//        List<WebElement> listData = driver.findElements((By.cssSelector("div.dealer_branch h4"));
//                Assert.assertEquals(listData.size(),16);
//                for (WebElement deadled)
    }

    @AfterClass
    public void afterClass(){
//        driver.quit();
    }
}
