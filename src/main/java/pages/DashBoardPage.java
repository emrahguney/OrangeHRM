package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashBoardPage extends BaseTest {

    @Step("Kullanici basarili bir giris yaptigi onaylanir.")
    public DashBoardPage accountControl(String value) {

        String text = driver.findElement(By.linkText("Dashboard")).getText();

        Assert.assertEquals(value, text);

        return this;

    }
}