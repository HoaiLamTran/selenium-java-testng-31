package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;

public class Topic_03_Random {
    public static void main(String[] args){
        Random rand = new Random();
        System.out.println(rand.nextBoolean());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextFloat());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextLong());
        System.out.println(rand.nextInt(9999));
    }


}
