package smokesearch;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pageobject.HomePage;

public class Search_003_SubmitSearchTestCase extends BaseTestClass {
	
	@Test
	public void test_003(){
		
		HomePage homePage = openHomePage();
		homePage.searchForText("wordpress");
		homePage.input.pressEnter();
		
		homePage.resultDropdown.shouldBe(Condition.visible);
		
	}
	
}
