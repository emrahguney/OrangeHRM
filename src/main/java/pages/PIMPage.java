package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PIMPage extends BaseTest {

    @Step("PIM sayfasinda yeni bir ekleme yapabilmek icin add butonuna tiklanir.")
    public PIMPage addButtonClick(){

        driver.findElement(By.cssSelector("i[class*='bi-plus']")).click();

        return this;
    }

    @Step("Birinci isim alani doldurulur.")
    public PIMPage fillFirstName(String value){

        driver.findElement(By.cssSelector("[name='firstName']")).sendKeys(value);

        return this;
    }

    @Step("Ikinci isim alani doldurulur.")
    public PIMPage fillMiddleName(String value){

        driver.findElement(By.cssSelector("[name='middleName']")).sendKeys(value);

        return this;
    }
    @Step("Soyadi alani doldurulur.")
    public PIMPage fillLastName(String value){

        driver.findElement(By.cssSelector("[name='lastName']")).sendKeys(value);

        return this;
    }

    @Step("ID alani doldurulur.")
    public PIMPage fillEmployeeID(String value ){

        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(value);

        return this;
    }

    @Step("Login detaylari aktif edilir.")
    public PIMPage clickCreateLoginDetails(){

        driver.findElement(By.cssSelector("[type='checkbox']+span")).click();

        return this;
    }

    @Step("Login detaylarinda kullanici adi alani doldurulur.")
    public PIMPage fillUserNameforLoginDetails(String value)
    {
        driver.findElement(By.xpath("(//input[contains(@class,'oxd-input')])[6]")).sendKeys(value);

        return this;
    }

    @Step("Login detaylarinda sifre alani doldurulur.")
    public PIMPage fillPasswordforLoginDetails(String value)
    {
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(value);

        return this;
    }

    @Step("Login detaylarinda sifreyi onaylamak icin tekrar sifre alani doldurur.")
    public PIMPage fillConfirmPasswordforLoginDetails(String value)
    {
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(value);

        return this;
    }

    @Step("Login detaylarinda kayit butuna tiklanir ve kayit olunur.")
    public PIMPage clickSaveButton(){

        driver.findElement(By.cssSelector("[type='submit']")).click();

        return this;
    }

    @Step("Basarili bir kayit oldugu kontrol edilir.")
    public PIMPage pimRegisterControl(String value){

        String text = driver.findElement(By.cssSelector("div[aria-live='assertive']")).getText();

        Assert.assertTrue(text.contains(value));
        screenshot();

        return this;
    }
}
