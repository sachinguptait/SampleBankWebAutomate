package helpers;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return this.driver.get();
	}

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	@Parameters({ "browserName" })
	@BeforeTest
	public void prepareTest(String browserName) {
		HelperMethods helperMethods = new HelperMethods();
		Properties property = helperMethods.loadPropertyFile("config");
		WebDriver driver;
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else {
				driver = new EdgeDriver();
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get(property.getProperty("url"));
			setDriver(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest(alwaysRun = true)
	void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}

}
