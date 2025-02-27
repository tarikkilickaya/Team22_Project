package tests.eyup.US018;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EyupPage;
import utilities.Driver;
import utilities.TestBaseReport;

public class TC01 extends TestBaseReport {
    EyupPage eyupPage = new EyupPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void test01() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif Test","RequestID; geri isteme istegi");

        //Kullanici url'e gider
        Driver.getDriver().get("https://allovercommerce.com/");
        extentTest.info("Kullanici https://allovercommerce.com/ adresine gitti");

        //Sign In butonuna tiklanir
        eyupPage.anaSayfaSignInLink.click();
        extentTest.info("Kullanici sign-in linkine tikladi");

        //Kullanici bilgileri girilir ve sign in'e tiklanir.
        eyupPage.signInUsernameBox.sendKeys("team222");
        eyupPage.signInPasswordBox.sendKeys("*Team2215381571?");
        eyupPage.signInButton.click();
        extentTest.info("Kullanici bilgileri girildi ve sign in'e tiklandi");

        //Sign Out a tiklanir
        eyupPage.anaSayfaSignOutLink.click();
        extentTest.info("Sign outa tiklandi");

        //My Account sayfasina gelgini dogrular
        Assert.assertTrue(eyupPage.vendorMyAccountText.isDisplayed());
        extentTest.info("My Account sayfasina gelgini dogrulandi");

        //Store Manager butonuna tiklar
        eyupPage.storeManagerLink.click();
        extentTest.info("Store Manager butonuna tiklandi");

        //Store Maneger sayfasina gelgini dogrular
        Assert.assertTrue(eyupPage.vendorStoreManegerText.isDisplayed());
        Thread.sleep(3000);
        extentTest.info("Store Maneger sayfasina gelgini dogrulandi");

        //Refund butonuna tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        eyupPage.vendorRefundButton.click();
        extentTest.info("Refund butonuna tiklandi");

        //Reguest ID bolumunun gorunur oldugunu dogrular
        Assert.assertTrue(eyupPage.vendorRequestIdText.isDisplayed());
        extentTest.info("Reguest ID bolumunun gorunur oldugunu dogrulandi");


    }
}
