package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.lang.InterruptedException;

public class Topic_10_TextboxTextArea {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
//        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }
    @Test
    public void Topic_01_TechPanda(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

            String firstName = "Tran";
            String middleName = "Hoai";
            String lastName = "Lam";
            String fullName = firstName + " " + middleName + " " + lastName;
//            String fullName = firstName + " " + lastName;
            String emailAddress = "lamth" + new Random().nextInt(9999) + "@gmail.net";
            String password = "1234567";
            String thoughReview ="Best Phone\n Best Review\n Best product";
            String sumaryReview = "Hot Phone";
            String nickName = "Hoai Lam";

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("middlename")).sendKeys(middleName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(emailAddress);
        driver.findElement(By.id("password")).sendKeys(password);;
        driver.findElement(By.id("confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Thank you for registering with Main Website Store.");
        String copntractInfor = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(copntractInfor.contains(fullName));
        Assert.assertTrue(copntractInfor.contains(emailAddress));

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();;

        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys(thoughReview);
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys(sumaryReview);

        driver.findElement(By.cssSelector("input#nickname_field")).clear();
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys(nickName);
        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Your review has been accepted for moderation.");

    }
    @Test
    public void Topic_02_OrangeHRM(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String firstName = "Tran";
        String middleName = "Hoai";
        String lastName = "Lam";
        String userName = "LamTH" + new Random().nextInt(9999);
        String password = "123Asd!";
        String confirmPassword = "123Asd!";
        String passportNumber ="123-456-789-0000";
        String passportComment ="Tran Hoai Lam\n Best Review\n Best comment";

        //Admin
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
//        Thread.sleep(4000);

        driver.findElement(By.xpath("//span[text()='PIM']/parent::a")).click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name='middleName']")).sendKeys(middleName);
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lastName);

        String employeeId = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");
        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div//label")).click();

        // Employee
        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(userName);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(confirmPassword);
        driver.findElement(By.xpath("button[type='submit']")).click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button[contains(string(),'Add')]")).click();
        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passportNumber);
        driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(passportComment);
        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),passportNumber);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"),passportComment);

        driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

//        driver.findElement(By.xpath("a[text()='Immigration']")).click();
//        try
//        {
//            Thread.sleep(5000);
//        }
//        catch(InterruptedException e)
//        {
//            // this part is executed when an exception (in this example InterruptedException) occurs
//        }

        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='middleName']")).getAttribute("value"),middleName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),employeeId);
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).isEnabled());

        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
