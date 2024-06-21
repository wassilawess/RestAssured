package POJOComplexWithArr;

import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class POJOComplexWithArr {
	
	//@Test(priority=1)
	void createUser() {
		
		POJOadr adr[] = new POJOadr[2];
		adr[0] = new POJOadr();
		adr[1] = new POJOadr();
		
		adr[0].setStreet("12 st");
		adr[0].setType("apt");
		adr[0].setZip("75056");
		
		adr[1].setStreet("1224 dr");
		adr[1].setType("house");
		adr[1].setZip("75075");
		
		POJOReq data = new POJOReq();
		data.setId("007");
		data.setFirst("lara");
		data.setLast("mills");
		data.setAge("20");
		data.setAdr(adr);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/user")
		.then()
			.statusCode(201)
			.body("id", equalTo("007"))
			.body("first", equalTo("lara"))
			.log().all();	
		
	}
	
	@Test(priority=2)
	void updateUser() {
		
		POJOReq data = new POJOReq();
		data.setLast("jeen");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.patch("http://localhost:3000/user/007")
		.then()
			.statusCode(200)
			.body("id", equalTo("007"))
			.body("first", equalTo("lara"))
			.body("last", equalTo("jeen"))
			.body("age", equalTo("20"))
			.log().all();
	}
	
	//@Test(priority=3)
	void deleteUser() {
		
		when()
			.delete("http://localhost:3000/user/007")
		.then()
			.statusCode(200);
	}
}