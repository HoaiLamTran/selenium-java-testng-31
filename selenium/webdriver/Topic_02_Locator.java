package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import org.testng.annotations.Test;

public class Topic_02_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }
    @Test
    public void TC_01_ID(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtSearch"));
    }
    @Test
    public void TC_02_Class(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.className("inputsearch2"));
    }
    @Test
    public void TC_03_Link(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.linkText("Đăng Ký"));
        driver.findElement(By.linkText("Đăng Nhập"));
    }
    @Test
    public void TC_04_Name(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.name("txtFirstname"));
        driver.findElement(By.name("txtEmail"));
        driver.findElement(By.name("txtCEmail"));
        driver.findElement(By.name("txtPassword"));
        driver.findElement(By.name("txtCPassword"));
        driver.findElement(By.name("txtPhone"));
    }
    @Test
    public void TC_05_partialLinkText(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.partialLinkText("Đăng"));
        driver.findElement(By.partialLinkText("Nhập"));
    }
    @Test
    public void TC_06_Css(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Css vs ID
//        driver.findElement(By.xpath("input[id='txtFirstname'"));
//        driver.findElement(By.xpath("#txtFirstname"));
        driver.findElement(By.xpath("input#txtFirstname"));
    }

    @Test
    public void TC_07_tagName(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.tagName("a"));
    }

    @Test
    public void TC_08_Xpath(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div/div[8]/button"));
    }


    @AfterClass
    public void afterClass(){
//        driver.quit();
    }
}
