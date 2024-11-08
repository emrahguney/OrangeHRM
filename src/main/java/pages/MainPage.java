package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MainPage extends BaseTest {

    @Step("Kullanici login icin gerekli bilgileri yanlis girdigi icin hata mesaji alir.")
    public MainPage errorMessage(String value)
    {

        String text= driver.findElement(By.cssSelector("span[class*='oxd-text']")).getText();

        Assert.assertEquals(value,text);

        return this;
    }

    @Step("Kullanici gerekli alanlari doldurmadigi icin hata mesaji alir.")
    public MainPage errorAdminCreateMessage(String value){

        String text = driver.findElement(By.cssSelector("span[class*='oxd-input-field-error-message']")).getText();

        Assert.assertEquals(value,text);
        screenshot();
        return this;
    }
}
