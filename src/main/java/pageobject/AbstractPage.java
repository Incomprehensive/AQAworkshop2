package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public abstract class AbstractPage {
	
	// Elements
	public SelenideElement input = $(By.xpath("//header//input[contains(@class, 'AppSearchForm__input')]"));
	public SelenideElement resultDropdown = $(By.xpath("//header//form[contains(@class, 'AppSearchForm')]//ul"));
	public ElementsCollection resultListSuggestion = $$(By.xpath("//div[contains(@class, 'Suggestion__header')]//strong"));
	public ElementsCollection resultListTitles = $$(By.xpath("//div[contains(@class, 'Suggestion__header')]//a"));
	
	public List<String> assertCollectionContainsText(ElementsCollection collection, String text){
		List<String> titles = new ArrayList<>();
		for (SelenideElement element : collection){
			element.shouldHave(Condition.text(text));
		}
		return titles;
	}
	
	public void clickOnRandomElementFromCollection(){
		Random rand = new Random();
		int index = rand.nextInt(resultListTitles.size());
	}

}
