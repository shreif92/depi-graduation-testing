package Tests;


import Base.TestBase;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;

@Epic("User Management")
@Feature("Registration")
public class RegisterTest extends TestBase {

    Faker faker = new Faker();

    @Test
    @Story("User registers successfully")
    @Description("Validate that the user can register successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void userCanRegisterSuccessfully() {

        email = faker.internet().emailAddress(); // Set shared email

        homePage.openRegisterPage();
        registerPage.registerANewUser("osama", "mohamed", email, "01104863740", "12345678","12345678" );
        pageBase.waitForTextToAppear(registerPage.getSuccessMessageText(), 10);
        registerPage.isSuccessMessageDisplayed();
        homePage.loginOut();
    }

    @Test
    @Story("User cannot register with missing first name")
    @Description("Validate that the user cannot register when leaving the first name field blank")
    public void userCannotRegisterWhenFirstNameFieldLeftBlank() {
        String email = faker.internet().emailAddress();

        homePage.openRegisterPage();
        registerPage.registerANewUser("", "mohamed", email, "01104863740", "12345678","12345678");
        registerPage.validateErrorMessageWhenFirstNameFieldLeftBlank();
    }

    @Test
    @Story("User cannot register with missing last name")
    @Description("Validate that the user cannot register when leaving the last name field blank")
    public void userCannotRegisterWhenLastNameFieldLeftBlank() {
        String email = faker.internet().emailAddress();

        homePage.openRegisterPage();
        registerPage.registerANewUser("osama", "", email, "01104863740", "12345678", "12345678");
        registerPage.validateErrorMessageWhenLastNameFieldLeftBlank();
    }

    @Test
    @Story("User cannot register with missing confirm password")
    @Description("Validate that the user cannot register when leaving the email field blank")

    public void userCannotRegisterWhenEmailFieldLeftBlank() {
        String email = faker.internet().emailAddress();

        homePage.openRegisterPage();
        registerPage.registerANewUser("osama", "mohamed", "", "01104863740", "12345678", "12345678");
        registerPage.validateErrorMessageWhenEmailFieldLeftBlank();
    }

    @Test
    @Story("User cannot register with missing telephone")
    @Description("Validate that the user cannot register when leaving the telephone field blank")

    public void userCannotRegisterWhenTelephoneFieldLeftBlank() {
        String email = faker.internet().emailAddress();

        homePage.openRegisterPage();
        registerPage.registerANewUser("osama", "mohamed", email, "", "12345678", "12345678");
        registerPage.validateErrorMessageWhenTelephoneFieldLeftBlank();
    }
    @Test()
    @Story("User cannot register with missing password")
    @Description("Validate that the user cannot register when leaving the password field blank")
    public void userCannotRegisterWhenPasswordFieldLeftBlank() {
        String email = faker.internet().emailAddress();

        homePage.openRegisterPage();
        registerPage.registerANewUser("osama", "mohamed", email, "01104863740", "", "12345678");
        registerPage.validateErrorMessageWhenPasswordFieldLeftBlank();
    }

    @Test
    @Story("User cannot register with missing confirm password")
    @Description("Validate that the user cannot register when leaving the confirm password field blank")
    public void userCannotRegisterWhenConfirmPasswordFieldLeftBlank() {
        String email = faker.internet().emailAddress();

        homePage.openRegisterPage();
        registerPage.enterFirstName("osama");
        registerPage.enterLastName("mohamed");
        registerPage.enterEmail(email);
        registerPage.enterTelephone("01104863740");
        registerPage.enterPassword("12345678");
        registerPage.confirmPassword("");
        registerPage.subscribe("yes");
        registerPage.agreePrivacyPolicy();
        registerPage.clickContinue();
        registerPage.validateErrorMessageWhenConfirmPasswordFieldLeftBlank();
    }

    @Test
    @Story("User cannot register with already registered email")
    @Description("Validate that the user cannot register when using an already registered email")
    public void userCannotRegisterWithAlreadyRegisteredEmail() {
        homePage.openRegisterPage();
        registerPage.registerANewUser("osama", "mohamed", "test@gmail.com", "01104863740", "12345678", "12345678");
        registerPage.validateErrorMessageWhenEmailAlreadyRegistered();
    }

    @Test
    @Story("User cannot register without agreeing to privacy policy")
    @Description("Validate that the user cannot register when didn't agree to the privacy policy")
    public void userCannotRegisterWhenDidNotAgreeToPrivacyPolicy() {
        String email = faker.internet().emailAddress();

        homePage.openRegisterPage();
        registerPage.registerANewUserWithoutAgreePrivacyPolicy("osama", "mohamed", email, "01104863740", "12345678", "12345678");
        registerPage.validateErrorMessageWhenPrivacyPolicyNotAgreed();
    }

}




