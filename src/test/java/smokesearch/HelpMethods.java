package smokesearch;

import com.codeborne.selenide.SelenideElement;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.client.HttpClient;
import org.testng.annotations.DataProvider;
import utils.Constants;

import java.io.IOException;

public class HelpMethods {
	
	@DataProvider(name = "Data")
	public static Object[][] categories() {
		return new Object[][]{
				{"cat"},
				{"animals"},
				{"medical"},
				{"WordPress"},
				{"Joomla"},
				{"Weblium"}
		};
	}
	
	@DataProvider(name = "FalseRequests")
	public static Object[][] falseRequests() {
		return new Object[][]{
				{"'"},
				{"'1'='1'"},
				{"<script>alert(\"xss!\")</script>"},
				{"фірвфоів"},
				{"jasdhjasd"}
		};
	}
	
	public void submitSearch(String method, SelenideElement element){
		switch(method){
			case "Enter":
				element.pressEnter();
				break;
			case "Button":
				element.click();
				break;
			case "MouseClick":
				element.click(0, -100);
				break;
			}
	}
	
	public static String checkServiceProducts() {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(Constants.SERVICE_PRODUCTS)
				.build();
		Response response = null;
		try {
			response = client.newCall(request).execute().networkResponse();
			return response.message();
		} catch (IOException e) {
			e.printStackTrace();
			return "Error";
		}
	}
	
}
