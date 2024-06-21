package APIProject;

import org.testng.Assert;
import org.testng.annotations.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParsingJsonResponseData {

	// 1st approach

	// @Test
	void parseRes() throws InterruptedException {

		Response res = given().contentType("application/json").when().get("http://localhost:3000/books");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getHeader("content-type"), "application/json");

//	JsonPath jsonPath = res.jsonPath();
//	String bookName = jsonPath.get("books[0].title");	

		String bookName = res.jsonPath().get("books[0].title");
		Thread.sleep(2000);

		// Check if the bookName is null and handle it
		if (bookName == null) {
			System.err.println("The title of the first book is not found in the response.");
		} else {
			Assert.assertEquals(bookName, "The Great Gatsby");

		}
	}

	@Test
	void jsonparseRes() {
		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/books");			

		String responseBody = res.asString();
		//System.out.println("Response Body: " + responseBody);
		
		// Parse JSON response
		JSONArray jsonArray = new JSONArray(responseBody);
		
		boolean status = false;
	
		// Iterate through the JSON array and print each book's title
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String bookTitle = jsonObject.getString("title");
			//System.out.println("Book Title: " + bookTitle);			
			if(bookTitle.equals("The Great Gatsby")) {
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true);
		double totalPrice = 0;
		// total price
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String price = jsonObject.getString("price");
			//System.out.println("Book Title: " + bookTitle);			
			totalPrice = totalPrice + Double.parseDouble(price);
			
		}
		//System.out.println(totalPrice);
		double totalPricetwoval = Math.floor(totalPrice * 100) / 100;
		Assert.assertEquals(totalPricetwoval, 108.10);
	}

}
