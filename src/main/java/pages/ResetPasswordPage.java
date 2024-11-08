package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ResetPasswordPage extends BaseTest {

    @Step("Kullanici sifresini unuttugu hesabin kullanici adini girer.")
    public ResetPasswordPage newPasswordRequired(){

        driver.findElement(By.cssSelector("[name='username']")).sendKeys(username);

        return this;
    }

    @Step("Kullanici sifresini yenilemek icin kullanici adini girdikten sonra sifre sifirlama kutucuguna tiklar")
    public ResetPasswordPage resetPasswordClick(){

        driver.findElement(By.cssSelector("[class*='button--reset']")).click();
        return this;
    }

    @Step("Sifreniz sifirlanmistir mesaji alinir. ")
    public ResetPasswordPage resetPasswordSuccesfullMessage(String text){

        String value = driver.findElement(By.cssSelector("[class*='orangehrm-forgot-password-title']")).getText();
        Assert.assertEquals(value,text);

        return this;
    }

}
