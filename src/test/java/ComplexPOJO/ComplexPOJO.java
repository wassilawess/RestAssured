package ComplexPOJO;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ComplexPOJO {
	
	@Test
	void createUesr() {
		
		AdrPOJO adr= new AdrPOJO();
		adr.setType("third");
		adr.setZip("75093");
		adr.setStreetName("101 prospect");
		
		POJOreq basic = new POJOreq();
		basic.setId("004");
		basic.setFirstname("didou");
		basic.setLastname("benh");
		basic.setAge("7");
		basic.setAdress(adr);
		
			given()
				.contentType("application/json")
				.body(basic)
		    .when()
		    	.post("http://localhost:3000/basicInf")
		    .then()
		    	.statusCode(201)
		    	.body("firstname",equalTo("didou"))
		    	.log().all();
		
	}

}
