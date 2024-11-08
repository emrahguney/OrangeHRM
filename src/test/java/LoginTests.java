import base.BaseTest;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.MainPage;
import pages.ResetPasswordPage;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    MainPage mainPage = new MainPage();
    ResetPasswordPage resetPasswordPage= new ResetPasswordPage();
    @Test(description = "Basarili kullanici girisi kontrolu",priority = 1)
    public void loginSuccesfullControl(){

        loginPage.fillUserName(username)
                .fillPassword(password)
                .clickLoginButton();

        dashBoardPage.accountControl("Dashboard");

        screenshot();

    }

    @Test(description = "Basarisiz kullanici girisi kontrolu",priority = 2)
    public void loginUnSuccesfullControl(){

        loginPage.fillUserName("")
                .fillPassword(password)
                .clickLoginButton();

        mainPage.errorMessage("Required");

        screenshot();

    }


    @Test(description = "Parola unuttum kontrolu",priority = 3)
    public void forgotYourPassword(){

        loginPage.clickForgotPassword();

        resetPasswordPage.newPasswordRequired()
                .resetPasswordClick()
                .resetPasswordSuccesfullMessage("Reset Password link sent successfully");

        screenshot();

    }

}
