package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.GooglePage;

public class GoogleTest extends TestBase {

    @Test
    public void aramaTesti() {
        driver.get("http://google.com");
        // GooglePage class'indan bir tane nesne olusturduk. Parametre
        // olarak suan kullandigimiz driver'i gonderdik.
        GooglePage googlePage = new GooglePage(driver);
        googlePage.aramaKutusu.sendKeys("Selamlar..");
    }
}
