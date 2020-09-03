package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {

    /*
          Assert.assertTrue
          Assert.assertFalse
          Assert.assertEquals

          SoftAssert kullaniminin Hard Assert kullanimindan farklari:
          1. SoftAssert'te eger test basarisizsa, kalan kisim da calisiyor.
          2. SoftAssert classindan nesne olusturmak zorundayiz.
     */


    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test01() {
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(baslik.contains("Amazon"));
        softAssert.assertTrue(baslik.contains("Car"));
        softAssert.assertEquals("Online", baslik);
        softAssert.assertAll();// yukarida yaptigimiz tum dogrulamalar basarili ise testimiz basarili
                               // degilse testimiz basarisiz.
                               // HardAssert gibi

    }
    @Test
    public void test02() {
        driver.get("http://a.testaddressbook.com/sign_in");
        SoftAssert softAssert = new SoftAssert();
        WebElement emailKutusu = driver.findElement(By.id("session_email"));
        emailKutusu.sendKeys("testtechproed@gmail.com");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        softAssert.assertTrue(driver.getTitle().equals("Deneme"));

        WebElement sifreKutusu = driver.findElement(By.id("session_password"));
        sifreKutusu.sendKeys("Test1234!");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        softAssert.assertTrue(driver.getTitle().equals("Address Book"));


        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();

        WebElement signOutLinki = driver.findElement(By.partialLinkText("Sign out"));
        boolean gorunuyorMu = signOutLinki.isDisplayed();

        softAssert.assertAll();// Kesinlikle olmali .
                               // Ayni Hard Assert'teki gibi
                               //

    }


}
