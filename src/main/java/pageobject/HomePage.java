package pageobject;

import com.codeborne.selenide.Condition;

public class HomePage extends AbstractPage {
	
	public void searchForText(String text){
		input.setValue(text);
		resultDropdown.waitUntil(Condition.visible, 2000);
		resultListTitles.shouldHaveSize(5);
	}
	
}
