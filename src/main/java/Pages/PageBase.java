package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public Select select;
    public Actions action;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Wait time of 10 seconds
    }

    public  void navigateToWebsite()
    {
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
    }
    protected void waitUntilVisible(By locator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    protected void enter(By locator, String text) {

        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {

        driver.findElement(locator).click();
    }

    protected void waitFor(int seconds) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void waitForTextToAppear(String expectedText, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), expectedText));
    }


}



