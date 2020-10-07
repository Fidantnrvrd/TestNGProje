package com.techproed.smoketests;

import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import pages.FhcTripLoginPage;

public class FhcTripLoginTest extends TestBase {

    // 1. Adim : smoketests paketinin altinda FhcTripLoginTest
    // 2. Adim : icerisinde driver.get() ile properties dosyasinin icindeki
    //           fhc_login adresine gidin
    // 3. Adim : FhcTripLoginPage class'inin icerisindeki webelementleri kulanin
    // 4. Adim : webelementlerin icerisinde ConfigurationReader class'inin icerisndeki
    //           getProperty methodunu kullanarak bilgileri ekleyin.

    @Test
    public void test(){

        driver.get(ConfigurationReader.getProperty("fhc_login"));
        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);
        loginPage.userNameKutusu.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordKutusu.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButonu.click();


    }
}
