package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Constants;
import helpers.HelperMethods;

public class DebitCardPage extends BasePage {

	WebDriver driver;
	HelperMethods helperMethods = new HelperMethods();

	public DebitCardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[normalize-space(text())='Privy League Signature Debit Card']//parent::div//parent::div//span[text()='Compare']")
	private WebElement privyLeagueSignatureDebitCard_WebElement;

	@FindBy(xpath = "//p[normalize-space(text())='Access India Debit Card']//parent::div//parent::div//span[text()='Compare']")
	private WebElement accessIndiaDebitCard_WebElement;

	@FindBy(xpath = "//button//span[text()='Compare Debit Cards']")
	private WebElement compareDebitCard_WebElement;

	@FindBy(xpath = "//h1[contains(text(),'Comparing Privy League')]")
	private WebElement compareHeaderMessage_WebElement;

	@FindBy(xpath = "//h2[normalize-space(text())='Privy League Signature Debit Card']")
	private WebElement privyLeagueSignatureDebitCardOnComparePage;

	@FindBy(xpath = "//h2[normalize-space(text())='Access India Debit Card']")
	private WebElement accessIndiaDebitCardOnComparePage;

	public void comparePrivyLeagueSignatureAndAccessIndiaDebitCard() {
		helperMethods.waitTillElementIsVisible(driver, Duration.ofSeconds(Constants.LOW_WAIT),
				privyLeagueSignatureDebitCard_WebElement);
		helperMethods.waitTillElementIsClickable(driver, Duration.ofSeconds(Constants.LOW_WAIT),
				privyLeagueSignatureDebitCard_WebElement);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", privyLeagueSignatureDebitCard_WebElement);

		helperMethods.waitTillElementIsVisible(driver, Duration.ofSeconds(Constants.LOW_WAIT),
				accessIndiaDebitCard_WebElement);

		helperMethods.waitTillElementIsClickable(driver, Duration.ofSeconds(Constants.LOW_WAIT),
				accessIndiaDebitCard_WebElement);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", accessIndiaDebitCard_WebElement);

		helperMethods.waitTillElementIsVisible(driver, Duration.ofSeconds(Constants.LOW_WAIT),
				compareDebitCard_WebElement);
		helperMethods.waitTillElementIsClickable(driver, Duration.ofSeconds(Constants.LOW_WAIT),
				compareDebitCard_WebElement);
		compareDebitCard_WebElement.click();
	}

	public void switchToNewTab() {
		helperMethods.switchToRespectiveWindow(driver, 1);

	}

	public boolean isPrivyLeagueSignatureDebitCardOnComparePageVisible() {
		helperMethods.waitTillElementIsVisible(driver, Duration.ofSeconds(Constants.LOW_WAIT),
				privyLeagueSignatureDebitCardOnComparePage);
		return privyLeagueSignatureDebitCardOnComparePage.isDisplayed();

	}

	public boolean isAccessIndiaDebitCardOnComparePageVisible() {
		helperMethods.waitTillElementIsVisible(driver, Duration.ofSeconds(Constants.LOW_WAIT),
				accessIndiaDebitCardOnComparePage);
		return accessIndiaDebitCardOnComparePage.isDisplayed();

	}

	public String gettingCompareMessageHeader() {
		helperMethods.waitTillElementIsVisible(driver, Duration.ofSeconds(Constants.LOW_WAIT),
				compareHeaderMessage_WebElement);
		return compareHeaderMessage_WebElement.getText();

	}

}
