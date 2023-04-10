package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.HelperMethods;

public class BasePage extends HelperMethods {

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='/content/dam/Kotak/kotak-logo.png']")
	private WebElement mainPageLogo;

}
