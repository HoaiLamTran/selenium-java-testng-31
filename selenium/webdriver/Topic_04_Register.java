package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_Register {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }
    @Test
    public void TC_01_EmptyData(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");
    }
    @Test
    public void TC_02_iInvalidEmail(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.name("txtFirstname")).sendKeys("Hoai Lam");
        driver.findElement(By.id("txtEmail")).sendKeys("tranlam@@gmail.com");
        driver.findElement(By.name("txtCEmail")).sendKeys("tranlam@@gmail.com");
        driver.findElement(By.name("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0987456123");

        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email hợp lệ");
    }
    @Test
    public void TC_03_incorrectConfirmEmail(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.name("txtFirstname")).sendKeys("Hoai Lam");
        driver.findElement(By.id("txtEmail")).sendKeys("tranlam@gmail.com");
        driver.findElement(By.name("txtCEmail")).sendKeys("tranlam@gmail.vn");
        driver.findElement(By.name("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0987456123");

        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }
    @Test
    public void TC_04_invalidPassword(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.name("txtFirstname")).sendKeys("Hoai Lam");
        driver.findElement(By.id("txtEmail")).sendKeys("tranlam@gmail.com");
        driver.findElement(By.name("txtCEmail")).sendKeys("tranlam@gmail.com");
        driver.findElement(By.name("txtPassword")).sendKeys("123");
        driver.findElement(By.id("txtCPassword")).sendKeys("123");
        driver.findElement(By.id("txtPhone")).sendKeys("0987456123");

        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

    }
    @Test
    public void TC_05_incorrectConfirmPassword(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.name("txtFirstname")).sendKeys("Hoai Lam");
        driver.findElement(By.id("txtEmail")).sendKeys("tranlam@gmail.com");
        driver.findElement(By.name("txtCEmail")).sendKeys("tranlam@gmail.com");
        driver.findElement(By.name("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123");
        driver.findElement(By.id("txtPhone")).sendKeys("0987456123");

        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtCPassword")).sendKeys("123123");

        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");
    }
    @Test
    public void TC_06_invalidPhoneNumber(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Case 1: Less than 10 Chars
        driver.findElement(By.name("txtFirstname")).sendKeys("Hoai Lam");
        driver.findElement(By.id("txtEmail")).sendKeys("tranlam@gmail.com");
        driver.findElement(By.name("txtCEmail")).sendKeys("tranlam@gmail.com");
        driver.findElement(By.name("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("098745612");

        driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        // Case 2: More than 11 Chars
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("098745612111");

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        // Case 3: No begin number 0
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("987456121");

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }

    @AfterClass
    public void afterClass(){
//        driver.quit();
    }
}
