package smokesearch;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import pageobject.HomePage;
import pageobject.ProductSearchPage;

import static utils.Constants.reader;

public class BaseTestClass {
	
	protected String testCaseName = this.getClass().getSimpleName();
	protected String browser = reader.getValue("browser");
	
	@BeforeTest
	void initTest(){
		
		Configuration.browser = browser;
		Configuration.startMaximized = true;
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(browser.equals("chrome")){
			capabilities = new DesiredCapabilities().chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			capabilities.setCapability(ChromeOptions.CAPABILITY, "--disable-notifications");
			
			Configuration.browserCapabilities = capabilities;
			
		}
		
		Configuration.baseUrl = "https://storefront.templatemonsterdev.com/";
		Configuration.captureJavascriptErrors = true;
		Configuration.timeout = 4000;
		
		Configuration.savePageSource = false;
		Configuration.browserCapabilities = capabilities;
		
	}
	
	public HomePage openHomePage(){
		Selenide.open("");
		return new HomePage();
	}
	
	public ProductSearchPage openSearchPage(){
		Selenide.open("products");
		return new ProductSearchPage();
	}
	
}
