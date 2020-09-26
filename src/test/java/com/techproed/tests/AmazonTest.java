package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;
import pages.AmazonPage;

public class AmazonTest extends TestBase {

    @Test
    public void aramaTesti() {
        driver.get("http://amazon.com");
        // amazonPage'in icerisindeki bulmus oldugumuz WebElemet'i
        // kullanabilmek icin AmazonPage class'indan nesne uretiyoruz.
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.aramaKutusu.sendKeys("Baby Stroller");
    }
}
