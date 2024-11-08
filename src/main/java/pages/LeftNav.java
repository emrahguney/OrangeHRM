package pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LeftNav extends BaseTest {

    @Step("Kullanici Admin sayfasina girer")
    public LeftNav AdminClick(){

        driver.findElement(By.linkText("Admin")).click();
        return this;
    }

    @Step("Kullanici PIM sayfasina girer")
    public LeftNav PIMClick(){

        driver.findElement(By.linkText("PIM")).click();

        return this;
    }

    @Step("Kullanici Recruitment sayfasina girer")
    public LeftNav RecruitmentClick(){

        driver.findElement(By.linkText("Recruitment")).click();

        return this;
    }

    @Step("Kullanici Buzz sayfasina girer")
    public LeftNav BuzzClick(){

        driver.findElement(By.linkText("Buzz")).click();

        return this;

    }
}
