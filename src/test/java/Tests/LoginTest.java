package Tests;

import Base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("User Management")
@Feature("Login")
public class LoginTest extends TestBase {

    @Test()
    public void userCanLoginSuccessfully() {
        // Navigate to the login page
        homePage.openLoginPage();
        loginPage.login(email, "12345678");
        loginPage.assertSuccessfulLoginMessage();
        homePage.loginOut();
    }



    @Test()
    public void userCannotLoginWithInvalidEmail() {
        // Navigate to the login page
        homePage.openLoginPage();
        loginPage.login("asdasdasdsfsdfdgdf@ttrl.com", "12345678");
        // Verify that the error message is displayed
        loginPage.assertLoginErrorMessage();
    }

    @Test()
    public void userCannotLoginWithInvalidPassword() {
        // Navigate to the login page
        homePage.openLoginPage();
        loginPage.login(email, "invalidPassword");
        loginPage.assertLoginErrorMessage();
    }

    @Test()
    public void userCannotLoginWithEmptyEmail() {
        // Navigate to the login page
        homePage.openLoginPage();
        loginPage.login("", "12345678");
        loginPage.assertLoginErrorMessage();
    }

    @Test()
    public void userCannotLoginWithEmptyPassword() {
        // Navigate to the login page
        homePage.openLoginPage();
        loginPage.login("Tester12@gmail.com", "");
        loginPage.assertLoginErrorMessage();
    }

    @Test()
    public void userCannotLoginWithEmptyFields() {
        // Navigate to the login page
        homePage.openLoginPage();
        loginPage.login("", "");
        loginPage.assertLoginErrorMessage();
    }


}
