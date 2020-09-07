package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase {  //DAY 14 - 6 Eylul 2020 Pazar

   @Test
    public void test01() {
       driver.get("http://amazon.com");

       // 1. Adim : Mouse'u moveToElement methodu kullanarak, Account & Lists
       //           Webelementinin uzerine goturun.
       // 2. Adim : Start here . Linkine tiklayin

       WebElement webElement = driver.findElement(By.id("nav-link-accountList"));
       Actions actions = new Actions(driver);
       // mouse'u webelement uzerine goturme islemi yapiyoruz.
       actions.moveToElement(webElement).perform();

       // xpath ->    //*[.='Start here.']
       WebElement startHereLink = driver.findElement(By.partialLinkText("Start here."));
       startHereLink.click();

       // 3. Adim : Sayfanin title'i Amazon Registration ise testiniz basarili olsun.
       // True kullanarak Assert.assertTrue(driver.getTitle().equals("Amazon Registration"));
       // Assert.assertFalse(!driver.getTitle().equals("Amazon Registration"));
       Assert.assertEquals(driver.getTitle(),"Amazon Registration");
   }
   @Test(dependsOnMethods = "test01")
    public void test02() {
       WebElement yourName = driver.findElement(By.id("ap_customer_name"));
       yourName.sendKeys("Fidan Tanriverdi");

       driver.findElement(By.id("ap_email")).sendKeys("fiidan3434@gmail.com");
       driver.findElement(By.id("ap_password")).sendKeys("Kerem2010");
       driver.findElement(By.id("ap_password_check")).sendKeys("Kerem2010");
       driver.findElement(By.id("continue")).click();
   }

}
