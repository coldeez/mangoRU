package ru.mango.sandbox;

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


public class CheckCOVPages {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void CheckCriticalPages() {
    wd.get("http://www.site-release.mango.local/products/call_centre");
    wd.get("http://www.site-release.mango.local/products/call_centre/functions");
    wd.get("http://www.site-release.mango.local/products/call_centre/resheniya");
    wd.get("http://www.site-release.mango.local/products/call_centre/tariffs");
    wd.get("http://www.site-release.mango.local/support/tsentr_obrabotki_vyzovov");
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