package ru.mango.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AuthTests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void LoginTests() {
        wd.get("http://site-release.mango.local/");
        wd.findElement(By.linkText("Интернет-магазин")).click();
        wd.findElement(By.linkText("Вход")).click();
        wd.findElement(By.name("USER_LOGIN")).click();
        wd.findElement(By.name("USER_LOGIN")).clear();
        wd.findElement(By.name("USER_LOGIN")).sendKeys("16804850");
        wd.findElement(By.name("USER_PASSWORD")).click();
        wd.findElement(By.name("USER_PASSWORD")).clear();
        wd.findElement(By.name("USER_PASSWORD")).sendKeys("Qwerty12345");
        wd.findElement(By.xpath("//div[@class='enter_btn']/input")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
