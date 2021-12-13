package differentWaysToPostRequest;

import org.testng.annotations.Test;

import com.generics.pojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostOperationsUsingPojoClass {
	@Test
	public void create(){
pojoLibrary pojo=new pojoLibrary("Biswa","vtiger","completed","7");

given()
     .body(pojo)
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
