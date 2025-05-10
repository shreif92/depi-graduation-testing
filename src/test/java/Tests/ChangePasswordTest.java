package Tests;

import Base.TestBase;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase {

    @Test
    public void userCanChangePasswordSuccessfully() {



        // Navigate to the login page
        homePage.openLoginPage();
        loginPage.login(email, "12345678");
        loginPage.assertSuccessfulLoginMessage();

        // Change password
        changePasswordPage.changePasswordToNewPassword("Tester123$");
        changePasswordPage.assertSuccessMessageWhenChangeToNewPassword();

        // Logout
        homePage.loginOut();
    }

    @Test
    public void userCannotChangePasswordToTheSamePassword() {

        // Navigate to the login page
        homePage.openLoginPage();
        loginPage.login(email,"Tester123$");
        changePasswordPage.changePasswordToSamePassword("Tester123$");
        changePasswordPage.assertErrorMessageWhenChangeToSamePassword();
        homePage.loginOut();

    }

}
