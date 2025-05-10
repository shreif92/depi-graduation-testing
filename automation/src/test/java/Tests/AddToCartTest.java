package Tests;

import Base.TestBase;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
    }

    @Description("Validate that user can add MacBook to cart successfully")
    @Test
    public void userCanAddMacBookToCart() {
        productPage.navigateToMacBook();
        productPage.addToCart();
        productPage.verifyProductAddedSuccessfully("Success: You have added MacBook to your shopping cart!");
        productPage.verifyCartTotalItems("1 item");
    }

    @Description("Validate that user can add the same product twice")
    @Test
    public void userCanAddSameProductTwice() {
        productPage.navigateToMacBook();
        productPage.setQuantity("2");
        productPage.addToCart();
        productPage.verifyProductAddedSuccessfully("Success: You have added MacBook to your shopping cart!");
        productPage.verifyCartTotalItems("2 items");
    }

    @Description("Validate that guest user can add product to cart")
    @Test
    public void guestUserCanAddToCart() {
        // No login required
        productPage.navigateToMacBook();
        productPage.addToCart();
        productPage.verifyProductAddedSuccessfully("Success: You have added MacBook to your shopping cart!");
    }

    @Description("Validate that user cannot add negative quantity")
    @Test
    public void userCannotAddNegativeQuantity() {
        productPage.navigateToMacBook();
        productPage.setQuantity("-1");
        productPage.addToCart();
        productPage.verifyErrorMessage("Invalid quantity");
    }

    @Description("Validate that user cannot add zero quantity")
    @Test
    public void userCannotAddZeroQuantity() {
        productPage.navigateToMacBook();
        productPage.setQuantity("0");
        productPage.addToCart();
        productPage.verifyErrorMessage("Invalid quantity");
    }

    @Description("Validate system behavior with very high quantity")
    @Test
    public void userCannotAddVeryHighQuantity() {
        productPage.navigateToMacBook();
        productPage.setQuantity("1000");
        productPage.addToCart();
        productPage.verifyErrorMessage("Invalid quantity"); // Assuming the system has a limit on quantity
    }

    @Description("Validate that valid coupon can be applied")
    @Test
    public void userCanApplyValidCoupon() {
        productPage.navigateToMacBook();
        productPage.addToCart();
        productPage.viewCart();
        productPage.applyCoupon("VALID10"); // Assuming VALID10 is a valid coupon code
        productPage.verifyProductAddedSuccessfully("Success: Your coupon discount has been applied!");
    }

    @Description("Validate that invalid coupon cannot be applied")
    @Test
    public void userCannotApplyInvalidCoupon() {
        productPage.navigateToMacBook();
        productPage.addToCart();
        productPage.viewCart();
        productPage.applyCoupon("INVALID123");
        productPage.verifyErrorMessage("Warning: Coupon is either invalid, expired or reached its usage limit!");
    }

    @Description("Validate that expired coupon cannot be applied")
    @Test
    public void userCannotApplyExpiredCoupon() {
        productPage.navigateToMacBook();
        productPage.addToCart();
        productPage.viewCart();
        productPage.applyCoupon("EXPIRED2023");
        productPage.verifyErrorMessage("Warning: Coupon is either invalid, expired or reached its usage limit!");
    }

    @Description("Validate that coupon cannot be applied to empty cart")
    @Test
    public void userCannotApplyCouponToEmptyCart() {
        productPage.viewCart();
        productPage.applyCoupon("VALID10");
        productPage.verifyErrorMessage("Warning: Please add a product to your cart before applying a coupon!");
    }
}
