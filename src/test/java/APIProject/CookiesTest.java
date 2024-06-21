package APIProject;

import org.testng.annotations.*;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesTest {
	//https://reqres.in/api/users?page=2
	
	//@Test
	void testParams() {
		
		given()
			.pathParams("mypath","users")
			.queryParam("page", 2)
			.queryParam("id", 5)
		.when()
			.get("https://reqres.in/api/{mypath}")
		.then()
			.statusCode(200)
			.log().all();
	}

	//@Test
	void testCookie() {
		
		given()
		.when()
		  .get("https://www.google.com/")
        .then()
        	.statusCode(200)
        	.log().all();
		
	}
	//@Test
	void getCookie() {
		
		Response res =given()
					  .when()
						.get("https://www.google.com/");
		
		String cookie = res.getCookie("AEC");
		
		System.out.println("value of the cookie : "+cookie);
				
	}
	
	@Test
	void getCookies() {
		
		Response res = given()
						.when()
						.get("https://www.google.com/");
		
		Map<String,String> cookies = res.getCookies();
		
		for(String k : cookies.keySet()) {
			
			String cookieVal=res.getCookie(k);
			
			System.out.println(k+" : "+ cookieVal);
		}
	}
}
