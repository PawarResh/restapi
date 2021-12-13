package differentWaysToPostRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostOperationsUsingJsonFile {
	@Test
	public void create() throws FileNotFoundException {
		FileInputStream file=new FileInputStream("./src/test/resources/practice.json");
		
		given()
		      .body(file)
		      .contentType(ContentType.JSON)
		      
		      .when()
		      .post("http://localhost:8084/addProject")
		      
		      .then()
		      .assertThat().statusCode(201)
		      .and()
		      .contentType(ContentType.JSON)
		      .log().all();
		     }
}
