package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {

    @Step("Kullanici adi alani doldurulur.")
    public LoginPage fillUserName(String text){
        // wait.until(ExpectedConditions.visibilityOf((WebElement) By.cssSelector("[name='username']")));
        driver.findElement(By.cssSelector("[name='username']")).sendKeys(text);


        return this;
    }
    @Step("Sifre alani doldurulur.")
    public LoginPage fillPassword(String text){

        driver.findElement(By.cssSelector("[name='password']")).sendKeys(text);
        return this;
    }

    @Step("Login butonuna tiklanir.")
    public LoginPage clickLoginButton(){

        driver.findElement(By.cssSelector("[type='submit']")).click();
        return this;
    }

    @Step("Kullanici Parolami unuttuma tiklar.")
    public LoginPage clickForgotPassword(){

        driver.findElement(By.cssSelector("div[class='orangehrm-login-forgot']>p")).click();
        return this;
    }

}
