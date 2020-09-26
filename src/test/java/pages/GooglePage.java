package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePage {
    // bos bir tane driver degiskeni olusturduk.
    WebDriver driver;
    public GooglePage(WebDriver driver) {
        // parametre olarak gelen driver nesnesini, bu class'ta olusturdugumuz
        // (12. satirdaki) driver nesnesine esitledik. Bu sekilde yeniden bos bir
        // driver olusturmak yerine, zaten halihazirda kullandigimiz driver'i bu nesne ile
        // esitlemis olduk.
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "q")
    public WebElement aramaKutusu;

   /* @FindBy(xpath = "//tbody/tr")
    public List<WebElement> liste; // findElements ( s harfine dikkat)
     */

}
