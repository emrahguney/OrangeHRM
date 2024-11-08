package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuzzPage extends BaseTest {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @Step("Post alanina yazi yazilir.")
    public BuzzPage fillPost(String value){

        driver.findElement(By.cssSelector("textarea[class=oxd-buzz-post-input]")).sendKeys(value);

        return this;

    }

    @Step("Yaziyi gondermek icin post butonuna tiklanir.")
    public BuzzPage clickPostButton(){

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        return this;

    }

    @Step("Post basarili bir sekilde gonderildigi kontrol edilir.")
    public BuzzPage postControl(String value)
    {

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("div[aria-live='assertive']")),
                driver.findElement(By.cssSelector("div[aria-live='assertive']")).getText()));

        String text = driver.findElement(By.cssSelector("div[aria-live='assertive']")).getText();

        System.out.println(text);

        Assert.assertTrue(text.contains(value));

        return this;
    }


    @Step("Son gonderilen post u silmek icin 3 noktali isarete tiklanir.")
    public BuzzPage clickThreeDots(){

        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-three-dots'])[1]")).click();

        return this;

    }

    @Step("Post u silme islemi gerceklestirilir.")
    public BuzzPage clickDelete(){

        driver.findElement(By.xpath("//p[text()='Delete Post']")).click();

        return this;
    }

    @Step("Post u basarili bir sekilde silindigine dair kontrol edilir.")
    public BuzzPage confirmDelete(String value){

        driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();

        String text = driver.findElement(By.cssSelector("div[aria-live='assertive']")).getText();



        Assert.assertTrue(text.contains(value));
        screenshot();

        return this;
    }

}
