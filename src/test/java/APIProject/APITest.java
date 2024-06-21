package APIProject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class APITest {
	int id;

	@Test(priority = 1)
	void getUser() {

		given()

				.when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page", equalTo(2)).log()
				.all();
	}

	@Test(priority = 2)
	void createuser() {

		HashMap hm = new HashMap();
		hm.put("name", "wess");
		hm.put("job", "SDET");

		id = given().contentType("application/json").body(hm)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");

		// .then()
		// .log().all();
	}

	@Test(priority = 3, dependsOnMethods = { "createuser" })
	void updateUser() {
		HashMap hm = new HashMap();
		hm.put("name", "wassila");
		hm.put("job", "QA");

		given().contentType("application/json").body(hm).when().put("https://reqres.in/api/users/" + id).then()
				.statusCode(200).log().all();

	}

	@Test(priority = 4)
	void deleteuser() {
		given().when().delete("https://reqres.in/api/users/" + id).then().statusCode(204).log().all();

	}

}
