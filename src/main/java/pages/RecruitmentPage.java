package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecruitmentPage extends BaseTest {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @Step("Recruitment sayfasinda yeni bir ekleme yapabilmek icin add butonuna tiklanir.")
    public RecruitmentPage addButtonClick(){

        driver.findElement(By.cssSelector("i[class*='bi-plus']")).click();

        return this;
    }

    @Step("First name alani doldurulur.")
    public RecruitmentPage fillRecFirstName(String value)
    {
        driver.findElement(By.cssSelector("[name='firstName']")).sendKeys(value);

        return this;
    }
    @Step("Middle name alani doldurulur.")
    public RecruitmentPage fillRecMiddleName(String value)
    {

        driver.findElement(By.cssSelector("[name='middleName']")).sendKeys(value);

        return this;
    }
    @Step("Last name alani doldurulur.")
    public RecruitmentPage fillRecLastName(String value)
    {

        driver.findElement(By.cssSelector("[name='lastName']")).sendKeys(value);


        return this;
    }

    @Step("Email alani doldurulur.")
    public RecruitmentPage fillRecEmail(String value)
    {

        driver.findElement(By.xpath("(//input[@placeholder='Type here'])[1]")).sendKeys(value);

        return this;
    }

    @Step("Kaydet butonuna tiklanir.")
    public RecruitmentPage clickSaveButton()
    {

        driver.findElement(By.cssSelector("[type='submit']")).click();

        return this;
    }

    @Step("Basarili bir kayit oldugu kontrol edilir.")
    public RecruitmentPage RecRegisterControl(String value){
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("div[aria-live='assertive']")),
                driver.findElement(By.cssSelector("div[aria-live='assertive']")).getText()));

        String text = driver.findElement(By.cssSelector("div[aria-live='assertive']")).getText();

        Assert.assertTrue(text.contains(value));
        screenshot();
        return this;
    }
}
