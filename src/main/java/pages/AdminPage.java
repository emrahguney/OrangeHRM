package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AdminPage extends BaseTest {

    @Step("Kullanici Admin sayfasina girdigini onaylar")
    public AdminPage adminPageControl() {

        String text = driver.findElement(By.cssSelector("span[class='oxd-topbar-header-breadcrumb']")).getText();
        Assert.assertEquals(text, "Admin\n" + "User Management");
        return this;
    }

    @Step("Kullanici yeni bir Admin olusturmak icin Add butonuna tiklar")
    public AdminPage addButtonClick() {

        driver.findElement(By.cssSelector("i[class*='bi-plus']")).click();
        return this;
    }

    @Step("Admin olarak ekleme yapmasi icin listeden admini secer ve etkinlestirmeyi secer ")
    public AdminPage clickUserRoleAndStatusSelectEnabled() {

        List<WebElement> SelectArrows = driver.findElements(By.cssSelector("i[class*='oxd-select-text--arrow']"));

        SelectArrows.get(0).click();
        List<WebElement> UserRoles = driver.findElements(By.cssSelector("div[class='oxd-select-wrapper']>div[role='listbox']>div"));
        String text = UserRoles.get(1).getText();
        UserRoles.get(1).click();
        Assert.assertEquals(text, "Admin");


        SelectArrows.get(1).click();
        List<WebElement> Status = driver.findElements(By.cssSelector("div[class='oxd-select-wrapper']>div[role='listbox']>div"));
        String textEnabled = Status.get(1).getText();
        Status.get(1).click();
        Assert.assertEquals(textEnabled, "Enabled");

        return this;
    }


    @Step("Kullanici adi doldurulur")
    public AdminPage fillUserName(String value){


        driver.findElement(By.xpath("(//input[contains(@class,'oxd-input')])[2]")).sendKeys(value);
        Wait(1);

        return this;
    }

    @Step("Sifre alani doldurulur")
    public AdminPage fillPassword(String value){

        driver.findElement(By.cssSelector("div[class*='user-password-cell'] input[type='password']")).sendKeys(value);
        return this;
    }
    @Step("Sifreyi onaylamak icin tekrar sifre alani doldurur")
    public AdminPage fillConfirmPassword(String value){

        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(value);
        return this;
    }

    @Step("Save butonuna tiklar")
    public AdminPage clickSaveButton(){

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        return this;
    }
}
