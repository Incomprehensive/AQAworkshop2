package smokesearch;

import com.codeborne.selenide.Screenshots;
import org.testng.annotations.Test;
import pageobject.HomePage;

public class Search_002_HomePageNegativeTestCase extends BaseTestClass {
	
	@Test(dataProvider = "FalseRequests", dataProviderClass = HelpMethods.class)
	public void test_002(String input){
		
		HomePage homePage = openHomePage();
		homePage.searchForText(input);
		
		homePage.input.pressEnter();
		
		Screenshots.takeScreenShot("SecurityTesting");
		
	}
	
}
