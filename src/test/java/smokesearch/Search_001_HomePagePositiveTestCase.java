package smokesearch;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.ProductPage;

import java.util.Random;

public class Search_001_HomePagePositiveTestCase extends BaseTestClass {

	String title;
	int index;
	
	@Test(dataProvider = "Data", dataProviderClass = HelpMethods.class)
	public void test_001(String input){
		
		HomePage homePage = openHomePage();
		homePage.searchForText(input);
		
		homePage.resultListTitles.shouldHaveSize(5);
		homePage.assertCollectionContainsText(homePage.resultListSuggestion, input);
		
		Random rand = new Random();
		index = rand.nextInt(homePage.resultListTitles.size());
		title = homePage.resultListTitles.get(index).getText();
		
		homePage.resultListTitles.get(index).click();
		
		ProductPage productPage = new ProductPage();
		productPage.title.shouldBe(Condition.text(title));
		
	}
}
