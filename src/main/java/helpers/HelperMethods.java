package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperMethods {

	public void waitTillElementIsPresent(WebDriver driver, Duration timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitTillElementIsPresent(WebDriver driver, Duration timeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitTillElementIsClickable(WebDriver driver, Duration timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitTillElementIsClickable(WebDriver driver, Duration timeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitTillElementIsVisible(WebDriver driver, Duration timeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public Set<String> getAllWindows(WebDriver driver)
	{
		return driver.getWindowHandles();
	}
	
	public void switchToRespectiveWindow(WebDriver driver, int windowNumber)
	{
		Set<String> allWindows = getAllWindows(driver);
		ArrayList<String> windowHandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(windowHandles.get(windowNumber));
	}

	public Properties loadPropertyFile(String fileName) {
		Properties prop = new Properties();
		try {
			String path = System.getProperty("user.dir") + File.separator + "src/main/resources/data" + File.separator
					+ fileName + ".properties";

			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;

	}
}
