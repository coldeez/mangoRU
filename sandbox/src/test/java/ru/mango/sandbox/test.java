import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class test {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void test() {
        wd.get("http://site-release.mango.local/shop/products");
        wd.findElement(By.xpath("//div[@class='p-shop-products']/div[1]/div[3]/a[2]")).click();
        wd.findElement(By.linkText("ПОДКЛЮЧИТЬ")).click();

        wd.findElement(By.id("enter-login")).click();
        wd.findElement(By.id("enter-login")).sendKeys("\\undefined");
        wd.findElement(By.id("enter-pass")).click();
        wd.findElement(By.id("enter-pass")).sendKeys("\\undefined");
        wd.findElement(By.id("open_login_popup")).click();
        wd.findElement(By.cssSelector("div.popup_cross")).click();
        wd.findElement(By.id("enter-login")).click();
        wd.findElement(By.id("enter-login")).sendKeys("\\undefined");
        wd.findElement(By.id("enter-pass")).click();
        wd.findElement(By.id("enter-pass")).sendKeys("\\undefined");
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
