package smokesearch;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Search_000_CheckProductsAPI {
	
	@Test
	public void test_000(){
		
		// Make sure that Service Products is on
		assertEquals(HelpMethods.checkServiceProducts(), "OK", "Service Products does not respond");
		
	}
	
}
