package smokesearch;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pageobject.ProductSearchPage;

public class Search_006_PriceFilterTestCase extends BaseTestClass {
	
	String price;
	
	@Test
	public void test_006_a(){
		
		ProductSearchPage productSearchPage = openSearchPage();
		productSearchPage.priceFilterButton.click();
		productSearchPage.priceFilterLeftCounter.waitUntil(Condition.visible, 500);
		productSearchPage.priceFilterLeftCounter.dragAndDropTo("input[range=4170]");
		
		price = productSearchPage.priceFilterLeftCounter.getText();
		productSearchPage.searchTag.shouldHave(Condition.text(price));
		
	}
	
}
