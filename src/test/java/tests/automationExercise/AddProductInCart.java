package tests.automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.automationExercise.AutomationExercisePage;
import pages.automationExercise.CartPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductInCart {
    private WebDriver driver;
    private AutomationExercisePage homePage;
    private CartPage cartPage;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new AutomationExercisePage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    void shouldAddProductToCartSuccessfully() {
        homePage.navigate();
        homePage.goToProductsPage();
        homePage.searchFor("Polo");
        homePage.addFirstProductToCart();
        homePage.goToCart();

        assertEquals("Premium Polo T-Shirts", cartPage.getProductName(),
                "O nome do produto no carrinho está errado!");

        assertEquals("1", cartPage.getProductQuantity(),
                "A quantidade deveria ser 1!");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
