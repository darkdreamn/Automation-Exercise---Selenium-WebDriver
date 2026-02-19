package pages.automationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    private By productName = By.xpath("//td[@class='cart_description']//a");
    private By productQuantity = By.xpath("//td[@class='cart_quantity']/button");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public String getProductQuantity() {
        return driver.findElement(productQuantity).getText();
    }
}
