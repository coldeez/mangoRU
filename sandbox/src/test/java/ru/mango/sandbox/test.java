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
        wd.findElement(By.linkText("Вход")).click();
        wd.findElement(By.name("USER_LOGIN")).click();
        wd.findElement(By.name("USER_LOGIN")).sendKeys("\\undefined");
        wd.findElement(By.name("USER_PASSWORD")).click();
        wd.findElement(By.name("USER_PASSWORD")).sendKeys("\\undefined");
        wd.findElement(By.name("USER_LOGIN")).click();
        wd.findElement(By.name("USER_LOGIN")).clear();
        wd.findElement(By.name("USER_LOGIN")).sendKeys("16804850");
        wd.findElement(By.name("USER_PASSWORD")).click();
        wd.findElement(By.name("USER_PASSWORD")).clear();
        wd.findElement(By.name("USER_PASSWORD")).sendKeys("Qwerty12345");
        wd.findElement(By.xpath("//div[@class='enter_btn']/input")).click();



        wd.findElement(By.xpath("//div[@class='p-shop-products']/div[1]/div[2]/a[2]")).click();
        wd.findElement(By.id("covx_next")).click();
        wd.findElement(By.id("vpbx_next")).click();
        wd.findElement(By.id("select_vats_tariff_next")).click();
        wd.findElement(By.id("reg_from_numbers_email")).click();
        wd.findElement(By.id("reg_from_numbers_email")).sendKeys("\\undefined");
        wd.findElement(By.id("reg_from_numbers_password")).click();
        wd.findElement(By.id("reg_from_numbers_password")).sendKeys("\\undefined");
        wd.findElement(By.linkText("ПРОДОЛЖИТЬ")).click();
        wd.findElement(By.id("continue_number_case")).click();
        wd.findElement(By.id("order_button_check")).click();
        wd.findElement(By.xpath("//label[@for='PAYSYSTEM_1']")).click();
        if (!wd.findElement(By.id("PAYSYSTEM_1")).isSelected()) {
            wd.findElement(By.id("PAYSYSTEM_1")).click();
        }
        wd.findElement(By.cssSelector("input.btn.green")).click();
        wd.findElement(By.id("order_button_action")).click();
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
