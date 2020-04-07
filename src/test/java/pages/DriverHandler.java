package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverHandler {
	protected static WebDriver wd;
	RemoteWebDriver driver;
	private static DriverHandler _driverHandler;

	public WebDriver chooseDriver(

			String url, String browser) {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				DesiredCapabilities caps = new DesiredCapabilities();

				caps.setJavascriptEnabled(true);

				wd = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("Chrome")) {
				DesiredCapabilities caps = new DesiredCapabilities();

				caps.setJavascriptEnabled(true);

				caps.setCapability("takesScreenshot", true);

				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
				wd = new ChromeDriver();
				wd.manage().deleteAllCookies();
				// driver=chrome.getWebDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
				wd = new InternetExplorerDriver();
			} else if (browser.equalsIgnoreCase("Headless")) {

				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setJavascriptEnabled(true);
				caps.setCapability("takesScreenshot", true);
				caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "./driver/phantomjs");
				wd = new PhantomJSDriver(caps);

			} else if (browser.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.Microsoft.driver", "./driver/MicrosoftWebDriver.exe");
				wd = new EdgeDriver();

			}
			wd.get(url);
			wd.manage().window().maximize();
			wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return wd;
		} catch (WebDriverException e) {
			// logger.log(LogStatus.INFO,e.getMessage());
			System.out.println(e.getMessage());
			return wd;
		}
	}

	// Here is where the singleton pattern is applied, if the instance is null then
	// call constructor
	// if not, return the instance
	public static DriverHandler GetInstanceDriverHandler() {
		if (null == _driverHandler)
			_driverHandler = new DriverHandler();
		return _driverHandler;
	}

	public WebDriver getDriver() {
		return wd;

	}

	public void destroyDriver() {
		if (wd == null) {
			return;
		}
		wd.quit();
		wd = null;

	}

}
