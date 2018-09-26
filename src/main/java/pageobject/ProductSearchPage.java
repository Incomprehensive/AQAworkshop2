package pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductSearchPage extends AbstractPage {
	
	// Elements
	public SelenideElement searchField = $x("//*[@type='search']");
	public SelenideElement productContent = $x("//section[contains(@class, 'ProductsContent__main')]");
	public SelenideElement productLoader = $x("//span[contains(@class, TMLoader)]");
	
	public SelenideElement priceFilterButton = $x("//button[contains(@class, 'Dropdown') and @aria-label='Price']");
	
	public SelenideElement priceFilterLeftSlider = $x("//div[contains(@class, 'ProductsPriceFilter')]/span/span[3]");
	public SelenideElement priceFilterRightSlider = $x("//div[contains(@class, 'ProductsPriceFilter')]/span/span[4]");
	
	public SelenideElement priceFilterLeftSliderTarget = $x("//div[contains(@class, 'ProductsPriceFilter')]/span/input[2]");
	public SelenideElement priceFilterRightSliderTarget = $x("//div[contains(@class, 'ProductsPriceFilter')]/span/input[1]");
	
	public SelenideElement priceFilterLeftCounter = $x("//div[contains(@class, 'ProductsPriceFilter')]/span/span[5]");
	public SelenideElement priceFilterRightCounter = $x("//div[contains(@class, 'ProductsPriceFilter')]/span/span[6]");
	
	public SelenideElement searchTag = $x("//button[contains(@class, 'Tag')]");
	public SelenideElement searchTagClose = $x("//button[contains(@class, 'Tag')]//*[@id='remove']");
	public ElementsCollection searchTags = $$x("//button[contains(@class, 'Tag')]");
	
	public ElementsCollection productTitles= $$x("//h2[contains(@class, 'ProductCard')]");
	public ElementsCollection productCards = $$x("//article[contains(@class, 'TMLibraryProductCard')]");
	
}
