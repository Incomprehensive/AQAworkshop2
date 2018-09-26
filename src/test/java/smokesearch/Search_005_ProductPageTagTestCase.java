package smokesearch;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pageobject.ProductSearchPage;

public class Search_005_ProductPageTagTestCase extends BaseTestClass {
	
	@Test
	public void test_005_a(){
		
		ProductSearchPage productSearchPage = openSearchPage();
		productSearchPage.searchField.setValue("cat").pressEnter();
		productSearchPage.searchTagClose.click();
		
		productSearchPage.searchTag.shouldNot(Condition.exist);
		
	}
	
	@Test
	public void test_005_b(){
		
		ProductSearchPage productSearchPage = openSearchPage();
		productSearchPage.searchField.setValue("cat").pressEnter();
		productSearchPage.searchField.setValue("wordpress").pressEnter();
		
		productSearchPage.searchTags.shouldHaveSize(2);
	}
	
}
