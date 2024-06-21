package APIProject;

import org.testng.annotations.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*; 
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class GetHeader {

	@Test
	void testHeader() {
		
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.log().body();		
			
	}
	//@Test
	void getHeader() {
		
		Response res =given()
				.when()
				.get("https://google.com");
		
		String h =res.getHeader("Content-Encoding");
		System.out.println("header is : "+h);
		
	}
	
	//@Test
	void getHeaders() {
		
		Response res = given()
					   .when()
					   	  .get("https://google.com");
		
		Headers myheaders = res.getHeaders();
		
		for(Header h:myheaders) {
			String name = h.getName();
			String val = h.getValue();
		
		
		System.out.println("Header : "+name+"  : "+val);
		
		}
	}
	
}
