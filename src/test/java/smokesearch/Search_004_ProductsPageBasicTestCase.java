package smokesearch;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pageobject.ProductPage;
import pageobject.ProductSearchPage;

import java.util.Random;

public class Search_004_ProductsPageBasicTestCase extends BaseTestClass{
	
	int index;
	String title;
	
	@Test(dataProvider = "Data", dataProviderClass = HelpMethods.class)
	public void test_004(String input){
		
		ProductSearchPage productSearchPage = openSearchPage();
		productSearchPage.searchField.setValue(input);
		productSearchPage.searchField.pressEnter();
		
		productSearchPage.searchTag.waitUntil(Condition.present, 500);
		productSearchPage.searchTag.shouldHave(Condition.text(input));
		
		Random rand = new Random();
		index = rand.nextInt(productSearchPage.productTitles.size());
		title = productSearchPage.productTitles.get(index).getText();
		
		productSearchPage.productTitles.get(index).hover().click();
		
		ProductPage productPage = new ProductPage();
		productPage.title.shouldBe(Condition.text(title));
	}
	
}
