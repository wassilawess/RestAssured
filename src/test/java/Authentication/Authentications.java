package Authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Authentications {
	
	//@Test (priority=1)
	void testBasic() {
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();		
	}
	//@Test (priority=2)
	void testdigest() {
		given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();		
	}
	//@Test (priority=3)
	void testpreemptive() {
		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();		
	}
	
	//token : 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
	
	@Test(priority=4)
	void barerToken() {
		
		String barerToken = "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";
		
		given()
			.header("Authorisation","Barer"+barerToken)
		.when()
			.get("https://api.github.com/octocat")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//@Test
	void testoauth1() {
		
		given()
			.auth().oauth(DEFAULT_URI, DEFAULT_SESSION_ID_VALUE, DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH)
		.when()
			.get("url")
		.then()
			.statusCode(200)
			.log().all();
	}
	//@Test
	void testoauth2() {
		
		given()
		.auth().oauth2("token generated from postman")
		.when()
		.get("url")
		.then()
		.statusCode(200)
		.log().all();
	}

}
