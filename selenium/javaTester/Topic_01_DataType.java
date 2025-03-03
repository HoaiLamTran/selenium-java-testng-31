package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_01_DataType {
    // Kieu ki tu
    char c = 'B';
    // Kieu so nguyen
    byte bNumber = 10;
    short sNumber = 100;
    int iNumber = 70000;
    long lNumber = 1000000;
    //Kieu so thuc
    float fNumber = 10.5f;
    double dNumber = 15.4d;
    // Kieu logic
    boolean Sex = true;

    // Kieu mang
//    String[] studentName = {"Nguyen Van A". "Tran Van B"};
    int[] studentAge = {25,28};

    // Kieu Object
    Object studentAddress = "123 Pham van dong";
    Object employeeAge = 28;
    Object employeeSex = false;

    // Kieu chuoi
    String name = "Lam";
    String employee = "32321231";

    // Class
    FirefoxDriver ffDirver = new FirefoxDriver();
    WebDriver dirver = new ChromeDriver();

    //Interface
    List<WebElement> textbox = dirver.findElements(By.cssSelector(""));
    //Collection
    ArrayList<String> studentCity = new ArrayList<String>();

    public static void main(String[] args){
        int x = 50;
        int y = 100;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }


}
