import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.Random;

public class HomeTest extends BaseTest {

    LeftNav leftNav = new LeftNav();
    LoginTests loginTests= new LoginTests();
    AdminPage adminPage = new AdminPage();
    MainPage mainPage = new MainPage();
    Random random = new Random();
    PIMPage pimPage = new PIMPage();
    RecruitmentPage recruitmentPage= new RecruitmentPage();
    BuzzPage buzzPage = new BuzzPage();
    String  firstNamePIM = "test"+random.nextInt(1000);
    String firstNameRec = "testRec"+random.nextInt(1000);


    @Test(description = "Yeni bir admin ekleme isleminin basarisizlik kontrolu")
    public void NewAdminCreateControl(){

        loginTests.loginSuccesfullControl();
        leftNav.AdminClick();

        adminPage.adminPageControl()
                .addButtonClick()
                .fillUserName("testdeneme"+random.nextInt(100000))
                .fillPassword("test1234.")
                .fillConfirmPassword("test1234.")
                .clickUserRoleAndStatusSelectEnabled()
                .clickSaveButton();

        mainPage.errorAdminCreateMessage("Required");



    }

    @Test(description = "PIM sayfasina basarili bir sekilde yeni bir kisi ekleme kontrolu")
    public void creatingAnewUserToPIM(){

        loginTests.loginSuccesfullControl();
        leftNav.PIMClick();

        pimPage.addButtonClick()
                .fillFirstName(firstNamePIM).fillMiddleName("test"+random.nextInt(1000)).fillLastName("test7355"+random.nextInt(1000))
                .fillEmployeeID("700")
                .clickCreateLoginDetails()
                .fillUserNameforLoginDetails("test"+random.nextInt(10000))
                .fillPasswordforLoginDetails("test123456")
                .fillConfirmPasswordforLoginDetails("test123456")
                .clickSaveButton()
                .pimRegisterControl("Successfully Saved");



    }



    @Test(description = "Recruitment sayfasina yeni bir aday ekleme kontrolu. ")
    public void creatingCandidate()
    {

        loginTests.loginSuccesfullControl();
        leftNav.RecruitmentClick();

        recruitmentPage.addButtonClick()
                .fillRecFirstName(firstNameRec)
                .fillRecMiddleName("test"+random.nextInt(1000))
                .fillRecLastName("test7355"+random.nextInt(1000))
                .fillRecEmail("test_"+random.nextInt(1000)+"@example.com")
                .clickSaveButton()
                .RecRegisterControl("Successfully Saved");




    }

    @Test(description = "Buzz sayfasina girip post gondermek ve sonra gonderilen o postu silme kontrolu")
    public void buzzControl(){

        loginTests.loginSuccesfullControl();
        leftNav.BuzzClick();

        buzzPage.fillPost("test1234")
                .clickPostButton()
                .postControl("Successfully Saved")
                .clickThreeDots()
                .clickDelete()
                .confirmDelete("Success\n");


    }


}
