package br.com.emprego.apinfo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		String dir = System.getProperty("user.dir");
		

		System.setProperty("webdriver.chrome.driver", dir+"/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", true);
		
		//System.out.println(dir);
		if (driver == null) {
			switch (Propriedades.BROWSER) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				driver = new ChromeDriver(options);
				break;
			}
		}

		return driver;
	}
}
