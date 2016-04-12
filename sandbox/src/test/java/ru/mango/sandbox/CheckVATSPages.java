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


public class CheckVATSPages {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void CheckCriticalPages() {
        wd.get("http://www.site-release.mango.local/products/virtualnaya_ats");
        wd.get("http://www.site-release.mango.local/products/virtualnaya_ats/functions");
        wd.get("http://www.site-release.mango.local/application/biznes_resheniya");
        wd.get("http://www.site-release.mango.local/tariffs/vpbx");
        wd.get("http://www.site-release.mango.local/tariffs/numbers");
        wd.get("http://www.site-release.mango.local/products/stoimost_nomera_8800");
        wd.get("http://www.site-release.mango.local/tariffs/connection");
        wd.get("http://www.site-release.mango.local/tariffs/8800");
        wd.get("http://www.site-release.mango.local/tariffs/call-center");
        wd.get("http://www.site-release.mango.local/support/virtualnaya_ats");
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