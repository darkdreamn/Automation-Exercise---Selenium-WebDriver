package pages.automationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutomationExercisePage extends BasePage {
    // localizadores
    private By productsLink = By.partialLinkText("Products");
    private By searchProduct = By.id("search_product");
    private By submitSearch = By.id("submit_search");

    // seletores
    private By firstProduct = By.cssSelector(".features_items .col-sm-4");
    private By addToCartButton = By.cssSelector(".overlay-content .add-to-cart");
    private By viewCartLink = By.xpath("//u[text()='View Cart']");

    public AutomationExercisePage(WebDriver driver) {
        super(driver);
    }
    public void navigate() {
        driver.get("https://automationexercise.com");
    }
    public void goToProductsPage() {
        clickIgnoreAds(productsLink);
        wait.until(ExpectedConditions.elementToBeClickable(productsLink)).click();
    }
    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
    public void searchFor(String term) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchProduct));
        input.clear();
        input.sendKeys(term);
        wait.until(ExpectedConditions.elementToBeClickable(submitSearch)).click();
    }
    public void addFirstProductToCart() {
        Actions actions = new Actions(driver);
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
        actions.moveToElement(product).perform();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }
    private void clickIgnoreAds(By locator) {
        String oldUrl = driver.getCurrentUrl();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        if (driver.getCurrentUrl().contains("#google_vignette") || driver.getCurrentUrl().equals(oldUrl)) {
            System.out.println("Anúncio detectado! Tentando contornar");
            driver.navigate().refresh();
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }
    }
}
