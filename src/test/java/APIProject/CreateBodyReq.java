package APIProject;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class CreateBodyReq {
	int id;

	// using hashMap
	//@Test(priority = 1)	
	void createuserHash() {		
		HashMap data = new HashMap();
		data.put("id", "6");
		data.put("name", "lili");
		data.put("location", "nj");
		data.put("phone", "124578");		
		String arrcourses[]= {"kotlin","mokito"}; 
		data.put("courses", arrcourses);
		
		 given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("id", equalTo("6"))
			.body("name",equalTo("lili"))
			.body("location",equalTo("nj"))
			.body("phone",equalTo("124578"))
			.body("courses[0]",equalTo("kotlin"))
			.body("courses[1]",equalTo("mokito"))
			.header("content-type", "application/json")
			.log().all();		
	}

	//using org.json
	//@Test (priority=1)
	void createjsonlib() {		
		JSONObject data = new JSONObject();
		data.put("id","7");
		data.put("name","cami");
		data.put("location","lemmontree");
		data.put("phone","5651");
		String coursesArr[] = {"C","C++"};
		data.put("courses",coursesArr);
		
		given()
		 .contentType("application/json")
		 .body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("cami"))
			.log().all();		
	}
	
	//@Test(priority=1)
	void createUserPOJO() {
		POJOreq data = new POJOreq();
		data.setId("8");
		data.setName("manel");
		data.setLocation("texas");
		data.setPhone("817706");
		String coursarr[]= {"css","Js"};
		data.setCourses(coursarr);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("manel"))
			.log().all();
	}
	
	//@Test(priority=2)
	void getuserPOJO(){
		POJOreq data = new POJOreq();
		data.getId();
		data.getName();
		data.getLocation();
		data.getPhone();
		data.getCourses();
		
		when()
			.get("http://localhost:3000/students/8")
		.then()
			.statusCode(200)
			.body("name", equalTo("manel"))
			.log().all();
}
	
	//using external json file
	@Test(priority=1)
	void creatuserExternalFile() throws FileNotFoundException {
		
		File f = new File(".\\body.json");
		FileReader fr = new FileReader(f);		
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("mamina"))
			.log().all();
	}
	
@Test(priority=3)
void deleteuser() {
	given()		
	.when()
		.delete("http://localhost:3000/students/9")		
	.then()
		.statusCode(200)
		.log().all();
}


}
