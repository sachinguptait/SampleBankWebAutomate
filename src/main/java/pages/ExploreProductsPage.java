package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Constants;
import helpers.HelperMethods;

public class ExploreProductsPage extends BasePage {

	WebDriver driver;
	HelperMethods helperMethods = new HelperMethods();

	public ExploreProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Explore Products")
	private WebElement exploreProduct_WebElement;

	@FindBy(linkText = "Cards")
	private WebElement cards_WebElement;

	@FindBy(linkText = "Debit Cards")
	private WebElement DebitCards_WebElement;

	public void openExploreProductTab() {
		helperMethods.waitTillElementIsClickable(driver, Duration.ofSeconds(Constants.LOW_WAIT),
				exploreProduct_WebElement);
		exploreProduct_WebElement.click();
	}

	public void openCardsTab() {
		helperMethods.waitTillElementIsClickable(driver, Duration.ofSeconds(Constants.LOW_WAIT), cards_WebElement);
		cards_WebElement.click();
	}

	public void openCreditCardsPage() {
		helperMethods.waitTillElementIsClickable(driver, Duration.ofSeconds(Constants.LOW_WAIT), DebitCards_WebElement);
		DebitCards_WebElement.click();
	}

}
