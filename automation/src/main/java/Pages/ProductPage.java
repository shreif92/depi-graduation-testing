package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


    public class ProductPage extends PageBase {

        public ProductPage(WebDriver driver) {
            super(driver);
        }

        // Locators
        private final By laptopsNotebooksLink = By.xpath("//a[contains(text(),'Laptops & Notebooks')]");
        private final By showAllLaptopsLink = By.xpath("//*[text()='Show AllLaptops & Notebooks']");
        private final By macBookLink = By.xpath("//a[contains(text(),'MacBook')]");
        private final By addToCartButton = By.id("button-cart");
        private final By successMessage = By.cssSelector(".alert-success");
        private final By cartTotal = By.id("cart-total");
        private final By quantityInput = By.id("input-quantity");
        private final By cartDropdown = By.id("cart");
        private final By couponAccordion = By.xpath("//a[contains(text(),'Use Coupon Code')]");
        private final By couponInput = By.id("input-coupon");
        private final By applyCouponButton = By.id("button-coupon");
        private final By errorMessage = By.cssSelector(".alert-danger");
        private final By checkoutLink = By.xpath("//a[contains(text(),'Checkout')]");
        private final By viewCartLink = By.xpath("//strong[contains(text(),'View Cart')]");

        // Navigation Methods
        public void navigateToMacBook() {
            click(laptopsNotebooksLink);
            click(showAllLaptopsLink);
            click(macBookLink);
        }

        // Cart Actions
        public void setQuantity(String quantity) {
            driver.findElement(quantityInput).clear();
            enter(quantityInput, quantity);
        }

        public void addToCart() {
            click(addToCartButton);
            waitForSuccessMessage();
        }

        public void openCart() {
            click(cartDropdown);
        }

        public void viewCart() {
            openCart();
            click(viewCartLink);
        }

        // Coupon Actions
        public void applyCoupon(String code) {
            click(couponAccordion);
            enter(couponInput, code);
            click(applyCouponButton);
        }

        // Get Messages/Status
        public String getSuccessMessage() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return driver.findElement(successMessage).getText();
        }

        public String getErrorMessage() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return driver.findElement(errorMessage).getText();
        }

        public String getCartTotal() {
            return driver.findElement(cartTotal).getText();
        }

        private void waitForSuccessMessage() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        }

        // Validations
        public void verifyProductAddedSuccessfully(String expectedText) {
            String message = getSuccessMessage();
            Assert.assertTrue(message.contains(expectedText),
                    "Product was not added to cart successfully. Expected: " + expectedText + ", Got: " + message);
        }

        public void verifyCartTotalItems(String expectedCount) {
            String total = getCartTotal();
            Assert.assertTrue(total.contains(expectedCount),
                    "Cart total does not show correct item count. Expected: " + expectedCount + ", Got: " + total);
        }

        public void verifyErrorMessage(String expectedError) {
            String error = getErrorMessage();
            Assert.assertTrue(error.contains(expectedError),
                    "Error message not as expected. Expected: " + expectedError + ", Got: " + error);
        }
    }

